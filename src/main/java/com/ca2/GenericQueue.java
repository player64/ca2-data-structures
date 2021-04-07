package com.ca2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericQueue<T> implements IQueue<T>, Iterable<T> {

    private final IList<T> queueData;

    public GenericQueue() {
        queueData = new GenericArrayList<>();
    }

    public GenericQueue(IList<T> data) {
        queueData = data;
    }

    /**
     * Inserts the specified element into the queue at the end
     *
     * @param element the element argument.
     */
    @Override
    public void enqueue(T element) {
        queueData.add(element);
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     * //throw NoSuchElementException as appropriate
     */
    @Override
    public T dequeue() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        // receive the deleted data
        T entry = queueData.get(0);
        queueData.remove(0);
        return entry;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     * //throw NoSuchElementException as appropriate
     */
    @Override
    public T first() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        return queueData.get(0);
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return {@code true} if and only if this queue contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return queueData.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < queueData.size(); i++) {
            builder.append(queueData.get(i)).append(",");
        }
        return builder.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new GenericIteratorStackQueue<>(queueData);
    }
}
