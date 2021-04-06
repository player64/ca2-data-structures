package com.ca2;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void push() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals("1;2;3;4;", stack.toString());
    }

    @Test
    void pushWithGenericArrayList() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(1);
        list.add(2);

        GenericArrayList<Integer> list2 = new GenericArrayList<>();
        list2.add(3);
        list2.add(4);

        GenericStack<GenericArrayList<Integer>> stack = new GenericStack<>();
        stack.push(list);
        stack.push(list2);

        assertEquals("1,2,;3,4,;", stack.toString());
    }

    @Test
    void pushWithGenericLinkedList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();
        list2.add(3);
        list2.add(4);

        GenericStack<GenericLinkedList<Integer>> stack = new GenericStack<>();
        stack.push(list);
        stack.push(list2);
        assertEquals("1,2,;3,4,;", stack.toString());
    }

    @Test
    void pop() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals("1;2;3;4;", stack.toString());
        assertEquals(4, stack.pop());
        assertEquals("1;2;3;", stack.toString());
        assertEquals(3, stack.pop());
        assertEquals("1;2;", stack.toString());
    }

    @Test
    void popEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void peek() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
        assertEquals("1;2;", stack.toString());
    }

    @Test
    void peekEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void empty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    void iterate()
    {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);

    }
}