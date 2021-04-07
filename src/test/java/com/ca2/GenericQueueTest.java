package com.ca2;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    @Test
    void enqueue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(1);
        assertEquals("1,", queue.toString());
    }

    @Test
    void enqueueWithGenericLinkedList(){
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        StringBuilder expectedOut = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
            expectedOut.append(i).append(",");
        }
        GenericQueue<Integer> queue = new GenericQueue<>(list);
        assertEquals(expectedOut.toString(), queue.toString());

        queue.enqueue(7);
        assertEquals(expectedOut.toString()+"7,", queue.toString());
    }

    @Test
    void dequeue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue());
        assertEquals("2,", queue.toString());
    }

    @Test
    void dequeueEmpty() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void first() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.first());
    }

    @Test
    void firstEmpty() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertThrows(NoSuchElementException.class, queue::first);
    }

    @Test
    void empty() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertTrue(queue.empty());
    }

    @Test
    void iterator() {
        GenericQueue<Integer> stack = new GenericQueue<>();
        stack.enqueue(0);
        stack.enqueue(1);

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

        GenericQueue<String> stack = new GenericQueue<>(list);
        int i = 0;
        for(String elem : stack) {
            assertEquals("test"+i, elem);
            i++;
        }
        assertEquals(2, i);
    }
}