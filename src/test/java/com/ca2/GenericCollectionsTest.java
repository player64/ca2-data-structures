package com.ca2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericCollectionsTest {
    private final GenericArrayList<Person> people = new GenericArrayList<>();
    private final GenericArrayList<Integer> numbers = new GenericArrayList<>();

    @BeforeEach
    void setUp() {
        people.add(new Person(20, "Hegarty", "Dermot"));
        people.add(new Person(23, "Minchin", "Tim"));
        people.add(new Person(19, "DiCamillo", "Kate"));
        people.add(new Person(44, "Leahy", "Mathew"));
        people.add(new Person(28, "Hardinge", "Frances"));
        people.add(new Person(24, "Bryson", "Bill"));
        people.add(new Person(26, "Ness", "Patrick")); // 16

        for (int j = 1; j <= 10; j++) {
            numbers.add(j);
        }
    }

    @Test
    void sort() {
        GenericCollections.sort(people);
        assertEquals(19, people.get(0).getAge());
        assertEquals(44, people.get(people.size() - 1).getAge());
    }

    @Test
    void max() {
        Person oldest = GenericCollections.max(people);
        assertEquals(44, oldest.getAge());
    }

    @Test
    void maxOnEmptyList() {
        GenericArrayList<Integer> emptyList = new GenericArrayList<>();
        assertThrows(NoSuchElementException.class, () -> GenericCollections.max(emptyList));
    }

    @Test
    void rotateByOne() {
        GenericCollections.rotate(numbers, 1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", numbers.toString());
    }

    @Test
    void rotateByTwo() {
        GenericCollections.rotate(numbers, 2);
        assertEquals("9,10,1,2,3,4,5,6,7,8,", numbers.toString());
    }

    @Test
    void rotateByFive() {
        GenericCollections.rotate(numbers, 5);
        assertEquals("6,7,8,9,10,1,2,3,4,5,", numbers.toString());
    }

    @Test
    void rotatePersonByTwo() {
        GenericCollections.rotate(people, 2);
        assertEquals(24, people.get(0).getAge());
        assertEquals(26, people.get(1).getAge());
        assertEquals(20, people.get(2).getAge());
        assertEquals(28, people.get(people.size() - 1).getAge());
    }
}