package com.ca2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericLinkedList<T> implements IList<T> {

    private Node head = null, tail = null;
    private int size = 0;


    private class Node {
        T data;
        Node next;

        // Constructor to create a new node
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Add an element to the end of the list
     *
     * @param elem element to be added
     */
    @Override
    public void add(T elem) {
        Node last = tail;
        Node newNode = new Node(elem);

        tail = newNode;

        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }

        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addToStart(element);
        } else if (index == size) {
            add(element);
        } else {
            Node newNode = new Node(element);
            Node prevNode = getNode(index - 1);
            Node nextNode = getNode(index);

            prevNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }

    /**
     * Add an element to the start of the list
     *
     * @param elem element to be added
     */
    public void addToStart(T elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
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
        Node node = getNode(index);
        assert node != null;
        T prevData = node.data;
        node.data = element;
        return prevData;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {
        Node node = getNode(index);
        return (node == null) ? null : node.data;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return Node specified position in this list
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param index the element to remove
     * @return the element removed from the list
     */
    @Override
    public T remove(int index) {
        Node deletedNode = getNode(index);

        Node prevNode;
        if (index == 0) {
            prevNode = head.next;
            head = prevNode;
        } else {
            prevNode = getNode(index - 1);
        }

        if (prevNode == null) {
            tail = null;
        } else if (index + 1 >= size) {
            prevNode.next = null;
            tail = prevNode;
        } else {
            prevNode.next = getNode(index + 1);
        }
        size--;

        return deletedNode.data;
    }

    /**
     * @param elem the element to remove
     * @return whether the elements was removed or not
     */
    @Override
    public boolean remove(T elem) {
        if (isEmpty()) {
            return false;
        }

        int index = getNodeIndex(elem);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This is new (to the interface) but should be straightforward to implement
     *
     * @param element the element to search found
     * @return whether the element was found or not
     */
    @Override
    public boolean contains(T element) {
        return getNodeIndex(element) >= 0;
    }

    /**
     * This return index
     * @param element the element to search found
     * @return index
     */
    private int getNodeIndex(T element) {
        int i = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
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
        //
        return new GenericLinkedListIterator();
    }

    /**
     * Rotates the elements in the specified list by the specified distance.
     *
     * @param distance
     */
    @Override
    public void rotate(int distance) {
        T temp;

        for (int i = 0; i < distance; i++) {
            temp = remove(size() - 1);
            add(0, temp);
        }

    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder string = new StringBuilder();
        while (current != null) {
            string.append(current.data).append(",");
            current = current.next;
        }
        return string.toString();
    }

    class GenericLinkedListIterator implements Iterator<T> {
        Node current = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
