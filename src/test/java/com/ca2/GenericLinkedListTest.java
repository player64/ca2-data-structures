package com.ca2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericLinkedListTest {

    @Test
    void add() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("test");
        list.add("test2");
        list.add("test3");
        assertEquals("[ test, test2, test3, ]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtIndex() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.add("t2");
        list.add("t3");
        list.add("t4");
        list.add("t5");
        list.add(2, "test");
        assertEquals("[ t1, t2, test, t3, t4, t5, ]", list.toString());
        assertEquals(6, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(7, "test"));
        list.add(6, "ttt");
        assertEquals("[ t1, t2, test, t3, t4, t5, ttt, ]", list.toString());
        list.add(0, "tek");
        assertEquals("[ tek, t1, t2, test, t3, t4, t5, ttt, ]", list.toString());
    }

    @Test
    void set() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("test");
        list.add("test to update");
        assertEquals("test to update", list.set(1, "New data"));
        assertEquals("[ test, New data, ]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, "fail"));
    }

    @Test
    void get() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.add("t2");

        assertEquals("t1", list.get(0));
        assertEquals("t2", list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void size() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        for(int i = 0; i < 10; ++i) {
            assertEquals(i, list.size());
            list.add("t");
        }
    }

    @Test
    void remove() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.add("t2");
        list.add("t3");

        assertEquals("t3", list.remove(2));
        assertEquals(2, list.size());
        assertEquals("[ t1, t2, ]", list.toString());
        list.add("t4");
        assertEquals("[ t1, t2, t4, ]", list.toString());
        assertEquals("t1", list.remove(0));
        assertEquals("[ t2, t4, ]", list.toString());
    }
    @Test
    void removeTheSame() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t2");
        list.add("t2");

        list.remove("t2");
        assertEquals("[ t2, ]", list.toString());
    }

    @Test
    void testRemove() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.add("t2");
        list.add("t3");

        list.remove("t3");
        assertEquals(2, list.size());
        assertEquals("[ t1, t2, ]", list.toString());
        list.add("t4");
        assertEquals("[ t1, t2, t4, ]", list.toString());
        list.remove("t1");
        assertEquals("[ t2, t4, ]", list.toString());
    }

    @Test
    void testRemoveAtIndex()
    {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.remove("t1");
        assertEquals("[ ]", list.toString());
        assertEquals(0, list.size());

        list.add("t1");
        assertEquals("[ t1, ]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void isEmpty() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t1");
        list.add("t2");
        list.add("t3");
        list.add("t4");
        assertTrue(list.contains("t1"));
        assertTrue(list.contains("t2"));
        assertTrue(list.contains("t3"));
        assertTrue(list.contains("t4"));
        assertFalse(list.contains("t5"));
    }

    @Test
    void iterator() {
    }
}