package com.ca2;

public interface IStack <T>{

    /**
     * Pushes an item onto the top of this stack
     * @param element the element argument.
     */
    public void push(T element);

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    public T pop(); //throw EmptyStackException as appropriate

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack
     */
    public T peek(); //throw EmptyStackException as appropriate

    /**
     * Tests if this stack is empty.
     *
     * @return  {@code true} if and only if this stack contains
     *          no items; {@code false} otherwise.
     */
    public boolean empty();
}
