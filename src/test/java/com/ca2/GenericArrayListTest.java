package com.ca2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {


    private GenericArrayList<String> arrayListStr;
    private GenericArrayList<Integer> arrayListInt;

    @BeforeEach
    void setUp() {
        arrayListStr = new GenericArrayList<>();
        arrayListInt = new GenericArrayList<>();
    }

    @Test
    void add() {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedInt = new StringBuilder();

        /*
        * Add 10 string and 10 integers to GenericArray and push to
        * */
        for(int i = 0; i < 10; i++) {
            arrayListStr.add("A");
            expectedString.append(" A,");

            arrayListInt.add(1);
            expectedInt.append(" 1,");
        }
        assertEquals("["+ expectedString +" ]", arrayListStr.toString());
        assertEquals("["+ expectedInt +" ]", arrayListInt.toString());
    }

    @Test
    void testAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.add(2, "test"));
        arrayListStr.add(0, "test");
        assertEquals("[ test, ]", arrayListStr.toString());
    }

    @Test
    void set() {
        arrayListStr.add("First");
        assertEquals("First", arrayListStr.set(0, "Second"));
        assertEquals("[ Second, ]", arrayListStr.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.set(2, "Out of range"));
    }

    @Test
    void get() {
        arrayListStr.add("Test");
        arrayListStr.add("Test2");
        assertEquals("Test", arrayListStr.get(0));
        assertEquals("Test2", arrayListStr.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.get(2));
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
        arrayListStr.add("test");
        //assertThrows(NullPointerException.class, () -> arrayList.contains(1));
        assertTrue(arrayListStr.contains("test"));
        assertFalse(arrayListStr.contains("test2"));
    }

    @Test
    void iterator() {
    }

    @Test
    void forEach() {
    }

    @Test
    void spliterator() {
    }
}