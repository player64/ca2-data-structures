package com.ca2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class GenericStack<T> implements IStack<T>, Iterable<T> {
    private final IList<T> stackData;

    public GenericStack() {
        stackData = new GenericArrayList<>();
    }

    public GenericStack(IList<T> data) {
        stackData = data;
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(T element) {
        stackData.add(element);
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        int key = stackData.size() - 1;
        T entry = stackData.get(key);
        stackData.remove(key);
        return entry;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        int key = stackData.size() - 1;
        return stackData.get(key);
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return stackData.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stackData.size(); i++) {
            builder.append(stackData.get(i)).append(",");
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericStackIterator();
    }

    class GenericStackIterator implements Iterator<T> {
        int cursor = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return stackData.size() > cursor;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public T next() {
            return stackData.get(cursor++);
        }
    }
}
