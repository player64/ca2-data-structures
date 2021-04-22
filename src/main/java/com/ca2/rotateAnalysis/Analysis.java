package com.ca2.rotateAnalysis;

import com.ca2.GenericCollections;
import com.ca2.IList;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Analysis {
    private final IList<Integer> list;
    private final int size;
    private final int distance;
    private Timer timer;

    public Analysis(IList<Integer> list, int size, int distance) {
        this.list = list;
        this.size = size;
        this.distance = distance;
        timer = new Timer();
        fillList();
    }

    /**
     * @return
     */
    public long rotate() {
        timer.start();
        list.rotate(distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * @return
     */
    public long collectionsRotate() {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        timer.start();
        GenericCollections.rotate(list, distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * @return
     */
    public long collectionsRotate2() {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        timer.start();
        GenericCollections.rotate2(list, distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public long add() {
       // int index = generateRandomIndex();
        timer.start();
        list.add(0, 1);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public long remove(int index) {
        // int index = generateRandomIndex();
        timer.start();
        list.remove(index);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public long get(int index) {
        // int index = generateRandomIndex();
        timer.start();
        list.get(index);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public long set(int index) {
        // int index = generateRandomIndex();
        timer.start();
        list.set(index, 2);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    public int generateRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(list.size());
    }

    /**
     *
     */
    private void fillList() {
        for(int i = 0; i <= size; ++i) {
            list.add(i);
        }
    }

    /**
     * It converts the time given in nano seconds to micro seconds
     * @param time in nano Seconds
     * @return time in micro seconds
     */
    private long convertTimeToMicroSeconds(long time) {
        return TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
