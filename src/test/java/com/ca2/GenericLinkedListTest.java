package com.ca2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testAdd() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("t");
        list.add("t");
        list.add("t");
        list.add("t");
        list.add("t");
        list.add(3, "test");
        System.out.println(list.toString());
        // assertEquals("[ test, ]", list.toString());
        // assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, "test"));
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void iterator() {
    }
}