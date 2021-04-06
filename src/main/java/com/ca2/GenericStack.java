package com.ca2;

import java.util.EmptyStackException;

// https://www.java2novice.com/data-structures-in-java/stacks/generic-stack/
// https://www.javaguides.net/2018/09/generic-stack-implementation-in-java.html

public class GenericStack<T> implements IStack<T> {

    private int stackSize = 0;
    private int currentCapacity;
    private static final int INITIAL_CAPACITY = 3;
    private T[] stackData;


    public GenericStack()
    {
        currentCapacity = INITIAL_CAPACITY;
        stackData = (T[]) new Object[currentCapacity];
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(T element) {
        if(stackSize >= stackData.length) {
            grow();
        }
        stackData[stackSize++] = element;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public T pop() {
        if(empty()) {
            throw new EmptyStackException();
        }

        T entry = stackData[--stackSize];
        stackData[stackSize] = null;

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
        if(empty()) {
            throw new EmptyStackException();
        }
        return stackData[stackSize-1];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return stackSize == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stackSize; i++) {
            builder.append(stackData[i]).append(";");
        }
        return builder.toString();
    }

    private void grow() {
        T[] tempArr = (T[]) new Object[stackData.length * 2];
        currentCapacity *= 2;

        //copy from the old space into the new
        for (int i = 0; i < stackData.length; i++) {
            tempArr[i] = stackData[i];
        }

        //Now, update so that our managed array points at the newly created array
        stackData = tempArr;
    }
}
