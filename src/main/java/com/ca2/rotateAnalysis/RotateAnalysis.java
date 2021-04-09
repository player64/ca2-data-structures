package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericCollections;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

import java.util.concurrent.TimeUnit;

public class RotateAnalysis {
    public static void main(String[] args) {
        final int SIZE = 50;
        int[] distances = {1, 2, 3, 5, 10};

        GenericArrayList<Integer> arrayList = new GenericArrayList<>();
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();

        // fill lists
        fillArray(arrayList, SIZE);
        fillArray(linkedList, SIZE);

        for (int distance : distances) {
            System.out.println("============== arrayList rotated by " + distance + " ==============");
            measure(arrayList, distance, "arrayList");

            System.out.println("============== linkedList rotated by " + distance + " ==============");
            measure(linkedList, distance, "linkedList");
        }
    }

    public static void measure(IList<Integer> list, int distance, String listName) {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        Timer timer = new Timer();
        timer.start();
        list.rotate(distance);
        timer.stop();
        printReadings(timer.getElapsedTime(), listName + ".rotate(" + distance + ")");

        // GenericCollections.rotate
        timer.start();
        GenericCollections.rotate(list, distance);
        timer.stop();
        printReadings(timer.getElapsedTime(), "GenericCollections.rotate(" + listName + "," + distance + ")");

        // GenericCollections.rotate2
        timer.start();
        GenericCollections.rotate2(list, distance);
        timer.stop();
        printReadings(timer.getElapsedTime(), "GenericCollections.rotate2(" + listName + "," + distance + ")");
    }

    public static long convertTimeToMicroSeconds(long time) {
        return TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }

    public static void fillArray(IList<Integer> list, int numberOfElements) {
        for (int i = 1; i <= numberOfElements; ++i) {
            list.add(i);
        }
    }

    public static void printReadings(long time, String name) {
        time = convertTimeToMicroSeconds(time);
        System.out.println("Function: " + name);
        System.out.println("Time: " + time + "us");
        System.out.println("---");
    }
}
