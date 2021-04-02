package com.ca2;

import java.util.Iterator;

public class GenericLinkedList<T> implements IList<T> {

    private Node head, tail;
    private int size = 0;

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

        if(last == null) {
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
        // https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
        if(!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if(index == size) {
            add(element);
        } else {
            Node current = head;
            for (int i = size; i > index; i--) {
                System.out.println(current.data);
                current = head.next;
            }
            /*Node first = head;
            for(int i = 0; i <= index; i++) {
                System.out.println(first.data);
                first = first.next;
            }*/

        }
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
        return false;
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
        return null;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder string = new StringBuilder();
        string.append("[ ");
        while(current != null) {
            string.append(current.data).append(", ");
            current = current.next;
        }
        string.append("]");
        return string.toString();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= size;
    }

    private class Node {
        T data;
        Node next;

        // Constructor to create a new node
        Node(T d) {
            data = d;
            next = null;
        }
    }


}
