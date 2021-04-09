package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericCollections;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

import java.util.concurrent.TimeUnit;

public class RotateAnalysis {
    public static void main(String[] args) {
        final int SIZE = 50;
/*        final int SIZE1 = SIZE * 2;
        final int SIZE2 = SIZE1 * 2;
        final int SIZE3 = SIZE2 * 2;
        final int SIZE4 = SIZE3 * 2;
        final int SIZE5 = SIZE4 * 2;*/

       // int[] testSizes = {SIZE, SIZE1, SIZE2, SIZE3, SIZE4, SIZE5};
        int[] rotateBy = {1, 2, 3, 5, 10, 15, 25};

        GenericArrayList<Integer> arrayList = new GenericArrayList<>();
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();

        // fill lists
        fillArray(arrayList, SIZE);
        fillArray(linkedList, SIZE);

        Timer timer = new Timer();

        for (int rotate : rotateBy) {

            // array list
            timer.start();
            GenericCollections.rotate2(arrayList, rotate);
            timer.stop();
            System.out.println("---");
            System.out.println("ArrayList rotated by " + rotate);
            System.out.println("Time: " + convertTimeToMicroSeconds(timer.getElapsedTime()) + "us");

            System.out.println("---");

            // linked list
            timer.start();
            GenericCollections.rotate2(linkedList, rotate);
            timer.stop();

            System.out.println("LinkedList rotated by " + rotate);
            System.out.println("Time: " + convertTimeToMicroSeconds(timer.getElapsedTime()) + "us");

            System.out.println("---");
            System.out.println("--- ROTATE BY COLLECTIONS ---");

            // collections rotate arrayList
            timer.start();
            GenericCollections.rotate(arrayList, rotate);
            timer.stop();
            System.out.println("Collections ArrayList rotated by " + rotate);
            System.out.println("Time: " + convertTimeToMicroSeconds(timer.getElapsedTime()) + "us");

            System.out.println("---");

            // collections rotate linkedList
            timer.start();
            GenericCollections.rotate(linkedList, rotate);
            timer.stop();
            System.out.println("Collections LinkedList rotated by " + rotate);
            System.out.println("Time: " + convertTimeToMicroSeconds(timer.getElapsedTime()) + "us");

            System.out.println("---------------------------------------");
        }
    }

    public static long convertTimeToMicroSeconds(long time) {
        return TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }

    public static void fillArray(IList<Integer> list, int numberOfElements) {
        for (int i = 1; i <= numberOfElements; ++i) {
            list.add(i);
        }
    }
}
