package com.ca2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private Person testPerson;


    @BeforeEach
    void setUp() {
        testPerson = new Person(20, "Doe", "Joe");
    }

    @Test
    void getFirstname() {
        assertEquals("Joe", testPerson.getFirstname());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", testPerson.getSurname());
    }

    @Test
    void getAge() {
        assertEquals(20, testPerson.getAge());
    }

    @Test
    void compareTo() {
        Person person1 = new Person(18, "Surname", "Name");
        Person person2 = new Person(20, "Surname", "Name");
        Person person3 = new Person(22, "Surname", "Name");

        assertEquals(1, testPerson.compareTo(person1));
        assertEquals(0, testPerson.compareTo(person2));
        assertEquals(-1, testPerson.compareTo(person3));
    }

    @Test
    void ToString() {
        String expected = "Person{" +
                "firstname='Joe" + '\'' +
                ", surname='Doe" + '\'' +
                ", age=20" +
                '}';
        assertEquals(expected, testPerson.toString());
    }
}
