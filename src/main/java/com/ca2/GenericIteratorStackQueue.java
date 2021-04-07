package com.ca2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericIteratorStackQueue<T> implements Iterator<T> {
    private int cursor = 0;
    private final IList<T> data;

    public GenericIteratorStackQueue(IList<T> data)
    {
        this.data = data;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return data.size() > cursor;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        try {
            return data.get(cursor++);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }
}
