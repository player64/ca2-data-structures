package com.ca2;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class GenericStack2Test {

    @Test
    void pushWithGenericArrayList() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(1);
        list.add(2);

        GenericStack2<Integer> stack = new GenericStack2<>(list);
        stack.push(3);
        assertEquals("1;2;3;", stack.toString());
    }

    @Test
    void pushWithGenericLinkedList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericStack2<Integer> stack = new GenericStack2<>(list);
        stack.push(4);
        assertEquals("1;2;4;", stack.toString());
    }

    @Test
    void pop() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericStack2<Integer> stack = new GenericStack2<>(list);
        assertEquals(2, stack.pop());
        assertEquals("1;", stack.toString());
    }

    @Test
    void popEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void peek() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericStack2<Integer> stack = new GenericStack2<>(list);
        assertEquals(2, stack.peek());
        assertEquals("1;2;", stack.toString());
    }

    @Test
    void peekEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    void empty() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        GenericStack2<Integer> stack = new GenericStack2<>(list);
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }
}