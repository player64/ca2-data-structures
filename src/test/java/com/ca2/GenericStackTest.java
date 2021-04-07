package com.ca2;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void pushWithGenericArrayList() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(1);
        list.add(2);

        GenericStack<Integer> stack = new GenericStack<>(list);
        stack.push(3);
        assertEquals("1,2,3,", stack.toString());
    }

    @Test
    void pushWithGenericLinkedList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericStack<Integer> stack = new GenericStack<>(list);
        stack.push(3);
        assertEquals("1,2,3,", stack.toString());
    }

    @Test
    void pop() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);

        GenericStack<Integer> stack = new GenericStack<>(list);
        assertEquals(2, stack.pop());
        assertEquals("1,", stack.toString());
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

        GenericStack<Integer> stack = new GenericStack<>(list);
        assertEquals(2, stack.peek());
        assertEquals("1,2,", stack.toString());
    }

    @Test
    void peekEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    void empty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    void iterator() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(0);
        stack.push(1);

        int i = 0;
        for(int no : stack) {
            assertEquals(i, no);
            ++i;
        }
        assertEquals(2, i);
    }

    @Test
    void iterateWithLinkedList()
    {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("test0");
        list.add("test1");

        GenericStack<String> stack = new GenericStack<>(list);
        int i = 0;
        for(String elem : stack) {
            assertEquals("test"+i, elem);
            i++;
        }
        assertEquals(2, i);
    }
}