package com.ca2;

public class GenericQueue<T> implements IQueue<T> {
    /**
     * Inserts the specified element into the queue
     *
     * @param element the element argument.
     */
    @Override
    public void enqueue(T element) {
        
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public T dequeue() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public T first() {
        return null;
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return {@code true} if and only if this queue contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return false;
    }
}
