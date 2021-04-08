package com.ca2;

import org.jetbrains.annotations.NotNull;

public class Person implements Comparable<Person>  {
    private final String firstname;
    private final String surname;
    private final int age;

    public Person(int age, String surname, String firstname) {
        this.age = age;
        this.surname = surname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull Person o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }


}
