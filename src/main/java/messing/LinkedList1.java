package messing;

import java.util.Scanner;
import java.io.*;

class MyGenericList<T extends Comparable<T>> {
    private class Node<B> {
        T value;
        Node<T> next;
    }

    private Node<T> first = null;
    int count = 0;

    public void add(T element) {
        Node<T> newnode = new Node<T>();
        newnode.value = element;
        newnode.next = null;

        if (first == null) {
            first = newnode;
        } else {
            Node<T> lastnode = gotolastnode(first);
            lastnode.next = newnode;
        }
        count++;
    }

    public void remove(T element) {
        Node<T> newnode = new Node<T>();
        Node<T> prevnode = new Node<T>();
        Node<T> curnode = new Node<T>();

        prevnode.value = element;
        curnode.next = null;
        int hopcount = 0;

        while (hopcount < count) {
            if (prevnode == element) {
                prevnode.next = first;
                Node<T> lastnode = gotolastnode(first);
                lastnode.next = newnode;
            }

            hopcount++;
        }
        count--;
    }

    public T get(int pos) {
        Node<T> Nodeptr = first;
        int hopcount = 0;
        while (hopcount < count && hopcount < pos) {
            if (Nodeptr != null) {
                Nodeptr = Nodeptr.next;
            }
            hopcount++;
        }
        return Nodeptr.value;
    }

    private Node<T> gotolastnode(Node<T> nodepointer) {
        if (nodepointer == null) {
            return nodepointer;
        } else {
            if (nodepointer.next == null)
                return nodepointer;
            else
                return gotolastnode(nodepointer.next);

        }

    }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;

    @Override
    public int compareTo(Employee arg0) {
        // TODO Auto-generated method stub
        return 0;
        // implement compareto method here.
    }

    Employee(String nm, int a) {
        name = nm;
        age = a;
    }
}

class City implements Comparable<City> {

    String name;
    int population;

    City(String nm, int p) {
        name = nm;
        population = p;
    }

    @Override
    public int compareTo(City arg0) {
        // TODO Auto-generated method stub
        return 0;
        // implement compareto method here.
    }

}

class GenericLinkedList {

    public static void main(String[] args) throws IOException {
        MyGenericList<Employee> ml = new MyGenericList<>();

        ml.add(new Employee("john", 32));
        ml.add(new Employee("susan", 23));
        ml.add(new Employee("dale", 45));
        ml.add(new Employee("eric", 23));

        Employee e1 = ml.get(0);
        System.out.println("Name " + e1.name + " Age " + e1.age);

        ml.remove(new Employee("john", 32));
        System.out.println("Name " + e1.name + " Age " + e1.age);

        ml.add(new Employee("john", 32));
        System.out.println("Name " + e1.name + " Age " + e1.age);


        MyGenericList<City> citylist = new MyGenericList<>();

        citylist.add(new City("Los Angeles", 320000));
        citylist.add(new City("Santa monica", 230000));
        citylist.add(new City("San Francisco", 450000));
        citylist.add(new City("San Diego", 23000));
        City c = citylist.get(2);
        System.out.println("City " + c.name + " Population " + c.population);
    }
}
