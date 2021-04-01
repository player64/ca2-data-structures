package com.ca2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index > nextFreeLoc) {
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
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if(index > nextFreeLoc) {
            throw new IndexOutOfBoundsException("Index cannot be outside the range");
        }

        for(int i = 0; i < nextFreeLoc; i++) {
            if(i == index) {
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
    public T get(int index) throws IndexOutOfBoundsException {
        if(index > nextFreeLoc) {
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
        return null;
    }

    /**
     * @param elem the element to remove
     * @return whether the elements was removed or not
     */
    @Override
    public boolean remove(T elem) {
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
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc; index++) {
            if (buffer[index].equals(element)) {
                matchFound = true;
                break;
            }
        }
        return matchFound;
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
            data.append(" ").append(buffer[i]).append(",");
        }

        return "[" + data + " ]";
    }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * Specified by:
     * iterator in interface  Iterable<T>
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer action) {

    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator spliterator() {
        return null;
    }
}
