package com.ca2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayList<T> implements IList<T> {
    /**
     * This will hold our data - remember an ArrayList is nothing more than a managed array
     */
    private T[] buffer;

    /**
     * Index of next free location - will also help us to determine if the buffer is full
     */
    private int nextFreeLoc;

    /**
     * This will change as buffer fills up and we allocate more and more storage space
     */
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3; //nice and small so that we test it quickly


    public GenericArrayList() {
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity];
    }

    /**
     * Add an element to the end of the list
     *
     * @param elem element to be added
     */
    @Override
    public void add(T elem) {
        growArrayIfNeeded();
        buffer[nextFreeLoc++] = elem;
    }

    /**
     * Inserts the specified element at the specified position in this list
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        if (index > nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be outside the range");
        }

        //Make sure that we "grow" the array if needed.
        growArrayIfNeeded();

        //shuffle everything up from right to left
        //Note that this is a much easier mechanism to implement than trying to insert the new
        //element and then shuffle everything from left to right
        for (int i = nextFreeLoc; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }

        //Now everything has moved up we can simply insert the new element
        buffer[index] = element;

        //Obviously, we've added an extra element so we must update to reflect this
        nextFreeLoc++;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        if (index > nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be outside the range");
        }

        for (int i = 0; i < nextFreeLoc; i++) {
            if (i == index) {
                T previousElement = buffer[i];
                buffer[i] = element;

                return previousElement;
            }
        }

        /* it never reaches here */
        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {
        if (index >= nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be outside the range");
        }

        return buffer[index];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return nextFreeLoc;
    }

    /**
     * @param index
     * @return the element removed from the list
     */
    @Override
    public T remove(int index) {
        if (index >= nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be outside the range");
        }
        T removedElement = buffer[index];
        for (int i = index; i < nextFreeLoc; i++) {
            /*
             * growArrayIfNeeded prevents ArrayIndexOutOfBoundsException if the size equals nextFreeLoc
             * */
            this.growArrayIfNeeded();
            buffer[i] = buffer[i + 1];
        }
        nextFreeLoc--;
        return removedElement;
    }

    /**
     * @param elem the element to remove
     * @return whether the elements was removed or not
     */
    @Override
    public boolean remove(T elem) {

        for (int i = 0; i < nextFreeLoc; i++) {
            if (buffer[i].equals(elem)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (nextFreeLoc == 0);
    }

    /**
     * This is new (to the interface) but should be straightforward to implement
     *
     * @param element the element to search found
     * @return whether the element was found or not
     */
    @Override
    public boolean contains(T element) {
        for (int index = 0; index < nextFreeLoc; index++) {
            if (buffer[index].equals(element)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Private helper method to check if the currently allocated space is full.
     * If it is then it will allocate a bigger array, copy the contents, and set our
     * instance field (buffer) to refer to the newly allocated space.
     */
    private void growArrayIfNeeded() {
        if (nextFreeLoc == currentCapacity) {
            //Allocate double the space - that will keep us going for a while
            T[] tempArr;
            tempArr = (T[]) new Object[buffer.length * 2];
            currentCapacity *= 2;

            //copy from the old space into the new
            for (int i = 0; i < buffer.length; i++) {
                tempArr[i] = buffer[i];
            }

            //Now, update so that our managed array points at the newly created array
            buffer = tempArr;
        }
    }


    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < nextFreeLoc; i++) {
            data.append(buffer[i]).append(",");
        }

        return data.toString();
    }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * Specified by:
     * iterator in interface  Iterable<T>
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIterator();
    }

    /**
     * Rotates the elements in the specified list by the specified distance.
     *
     * @param distance no of elements rotated by
     */
    @Override
    public void rotate(int distance) {
        if(distance < 0) {
            distance += size();
        }

        if(distance == 0) {
            return;
        }

        T temp;
        for (int i = 0; i < distance; i++) {
            temp = remove(size() - 1);
            add(0, temp);
        }
    }


    class GenericArrayListIterator implements Iterator<T> {
        int cursor = 0;  // the current element we are looking at

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return cursor < nextFreeLoc;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return buffer[cursor++];
        }
    }


}
