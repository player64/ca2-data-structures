package com.ca2;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericIteratorStackQueueTest {

    @Test
    void hasNext() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        GenericIteratorStackQueue<Integer> iterator = new GenericIteratorStackQueue<>(list);
        assertTrue(iterator.hasNext());
    }

    @Test
    void hasNextEmpty() {
        GenericIteratorStackQueue<Integer> iterator = new GenericIteratorStackQueue<>(new GenericLinkedList<>());
        assertFalse(iterator.hasNext());
    }

    @Test
    void next() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(1);
        list.add(2);
        GenericIteratorStackQueue<Integer> iterator = new GenericIteratorStackQueue<>(list);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}