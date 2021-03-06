package com.ca2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
         * Add 10 string and 10 integers to GenericArray and push to the expected result stringBuilder
         * */
        for (int i = 0; i < 10; i++) {
            arrayListStr.add("A");
            expectedString.append("A,");

            arrayListInt.add(i);
            expectedInt.append(i).append(",");
        }
        assertEquals(expectedString.toString() , arrayListStr.toString());
        assertEquals(expectedInt.toString(), arrayListInt.toString());
    }

    @Test
    void testAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.add(2, "test"));
        arrayListStr.add("t");
        arrayListStr.add(0, "test");
        arrayListStr.add(1, "test2");
        assertEquals("test,test2,t,", arrayListStr.toString());
    }

    @Test
    void set() {
        arrayListStr.add("First");
        assertEquals("First", arrayListStr.set(0, "Second"));
        assertEquals("Second,", arrayListStr.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.set(2, "Out of range"));
    }

    @Test
    void get() {
        arrayListStr.add("Test");
        arrayListStr.add("Test2");
        arrayListStr.add("Test3");
        assertEquals("Test", arrayListStr.get(0));
        assertEquals("Test2", arrayListStr.get(1));
        assertEquals("Test3", arrayListStr.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.get(3));
    }

    @Test
    void size() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, arrayListInt.size());
            arrayListInt.add(i);
        }
    }

    @Test
    void remove() {
        /**
         * Remove by index
         * */

        arrayListStr.add("Test");
        arrayListStr.add("Test2");
        arrayListStr.add("Test");

        assertEquals("Test", arrayListStr.remove(2));
        assertEquals(2, arrayListStr.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayListStr.get(2));
    }

    @Test
    void testRemove() {
        /**
         * Remove by element
         * */
        arrayListStr.add("Test");
        arrayListStr.add("Test");
        arrayListStr.add("Test3");
        assertTrue(arrayListStr.remove("Test"));
        assertFalse(arrayListStr.remove("Test2"));
        assertEquals(2, arrayListStr.size());
    }

    @Test
    void isEmpty() {
        assertTrue(arrayListStr.isEmpty());
        arrayListStr.add("test");
        assertFalse(arrayListStr.isEmpty());
    }

    @Test
    void contains() {
        arrayListStr.add("test");
        assertTrue(arrayListStr.contains("test"));
        assertFalse(arrayListStr.contains("test2"));
    }

    @Test
    void iterator() {
        arrayListStr.add("test0");
        arrayListStr.add("test1");
        arrayListStr.add("test2");

        int i = 0;
        for (String s : arrayListStr) {
            assertEquals("test"+i, s);
            ++i;
        }
        assertEquals(3, i);
    }

    @Test
    void rotate() {
        for (int i = 1; i <= 10; i++) {
            arrayListInt.add(i);
        }
        arrayListInt.rotate(1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", arrayListInt.toString());
    }

    @Test
    void rotateByTwo() {
        for (int i = 1; i <= 10; i++) {
            arrayListInt.add(i);
        }
        arrayListInt.rotate(2);
        assertEquals("9,10,1,2,3,4,5,6,7,8,", arrayListInt.toString());
    }

    @Test
    void rotateByFive() {
        for (int i = 1; i <= 10; i++) {
            arrayListInt.add(i);
        }
        arrayListInt.rotate(5);
        assertEquals("6,7,8,9,10,1,2,3,4,5,", arrayListInt.toString());
    }
}