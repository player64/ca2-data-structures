package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericCollections;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RotateAnalysis {
    public static void main(String[] args) {
        final int SIZE = 50;
        int[] distances = {1, 2, 3, 5, 10};



        // fill lists
        // fillArray(arrayList, SIZE);
        // fillArray(linkedList, SIZE);

        final int ROTATE_BY = 2;

        FileAnalysis file = new FileAnalysis("analysis3.md");
        AnalysisTableContent table = new AnalysisTableContent("Generics rotated by" + ROTATE_BY);

        String rowArrayList, rowLinkedList;

        GenericArrayList<Integer> arrayList = new GenericArrayList<>();
        long rotate = measureRotate(arrayList, ROTATE_BY);
        arrayList = new GenericArrayList<>();
        long gRotate = measureGRotate(arrayList, ROTATE_BY);
        arrayList = new GenericArrayList<>();
        long gRotate2 = measureGRotate2(arrayList, ROTATE_BY);

        rowArrayList = buildResults("GenericArrayList", rotate, gRotate, gRotate2);

        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
        long rotate3 = measureRotate(linkedList, ROTATE_BY);
        linkedList = new GenericLinkedList<>();
        long gRotate3 = measureGRotate(linkedList, ROTATE_BY);
        linkedList = new GenericLinkedList<>();
        long gRotate23 = measureGRotate2(linkedList, ROTATE_BY);

        rowLinkedList = buildResults("GenericLinkedList", rotate3, gRotate3, gRotate23);

        /*rowArrayList = measure(arrayList, ROTATE_BY, "GenericArrayList");
        rowLinkedList = measure(linkedList, ROTATE_BY, "GenericLinkedList");*/

        table.setRow(rowArrayList);
        table.setRow(rowLinkedList);

        file.writeFile(table.produceTable());


        table = new AnalysisTableContent("Normal rotated by" + ROTATE_BY);

        ArrayList<Integer> arrayListJ = new ArrayList<Integer>();
        long r = measureNotCollected(arrayListJ, ROTATE_BY);
        rowArrayList = buildResults("ArrayList", r, r, r);


        LinkedList<Integer> linkedListJ = new LinkedList<Integer>();
        long rr = measureNotCollected(linkedListJ, ROTATE_BY);
        rowLinkedList = buildResults("LinkedList", rr, rr, rr);


        table.setRow(rowArrayList);
        table.setRow(rowLinkedList);

        file.writeFile(table.produceTable());

    }

    public static String buildResults(String name, long r, long gR, long gR2) {
        return "| "+name + " | " + r + "μs | " + gR + "μs | " + gR2 + "μs |";
    }


    public static long measureNotCollected(List<Integer> list, int rotated) {
        for (int i = 1; i <= 50; ++i) {
            list.add(i);
        }
        Timer timer = new Timer();
        timer.start();
        Collections.rotate(list, rotated);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public static String measure(IList<Integer> list, int distance, String listName) {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        fillArray(list, 50);

        long rotate, gRotate, gRotate2;

        Timer timer = new Timer();
        timer.start();
        list.rotate(distance);
        timer.stop();

        rotate = convertTimeToMicroSeconds(timer.getElapsedTime());

        // GenericCollections.rotate
        timer.start();
        GenericCollections.rotate(list, distance);
        timer.stop();
        gRotate = convertTimeToMicroSeconds(timer.getElapsedTime());

        // GenericCollections.rotate2
        timer.start();
        GenericCollections.rotate2(list, distance);
        timer.stop();
        gRotate2 = convertTimeToMicroSeconds(timer.getElapsedTime());

        return "| "+listName + " | " + rotate + "μs | " + gRotate + "μs | " + gRotate2 + "μs |";
    }

    public static long measureRotate(IList<Integer> list, int distance) {
        fillArray(list, 50);
        Timer timer = new Timer();
        timer.start();
        list.rotate(distance);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public static long measureGRotate(IList<Integer> list, int distance) {
        fillArray(list, 50);
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        Timer timer = new Timer();
        timer.start();
        GenericCollections.rotate(list, distance);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public static long measureGRotate2(IList<Integer> list, int distance) {
        fillArray(list, 50);
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        Timer timer = new Timer();
        timer.start();
        GenericCollections.rotate2(list, distance);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
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
