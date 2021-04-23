package com.ca2.rotateAnalysis;

import com.ca2.GenericCollections;
import com.ca2.IList;
import java.util.concurrent.TimeUnit;

/**
 * Class is analysing a methods execution times
 */
public class Analysis {
    private final IList<Integer> list;
    private final int size;
    private Timer timer;

    /**
     * Class constructor initialises class attributes and fills the list
     * @param list IList GenericArrayList or GenericLinkedList
     * @param size int size of the list
     */
    public Analysis(IList<Integer> list, int size) {
        this.list = list;
        this.size = size;
        timer = new Timer();
        fillList();
    }

    /**
     * Measures execution time for IList rotate method
     * @return long time in micro second
     */
    public long rotate(int distance) {
        timer.start();
        list.rotate(distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measures execution time for GenericCollections IList rotate method
     * @return long time in micro second
     */
    public long collectionsRotate(int distance) {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        timer.start();
        GenericCollections.rotate(list, distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measures execution time for GenericCollections IList rotate2 method
     * @return long time in micro second
     */
    public long collectionsRotate2(int distance) {
        // it helps to initialize class and get accurate reading of the time
        GenericCollections.justInitialize();
        timer.start();
        GenericCollections.rotate2(list, distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measure the time on add method to the list at index 0
     * @return Time in micro seconds
     */
    public long add() {
        timer.start();
        list.add(0, 1);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measure the time on remove method to the list at given index number
     * @param index int index
     * @return Time in micro seconds
     */
    public long remove(int index) {
        timer.start();
        list.remove(index);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measure the time on get method to the list at given index number
     * @param index int index
     * @return Time in micro seconds
     */
    public long get(int index) {
        timer.start();
        list.get(index);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    /**
     * Measure the time on set method to the list at given index number
     * @param index int index
     * @return Time in micro seconds
     */
    public long set(int index) {
        timer.start();
        list.set(index, 2);
        timer.stop();
        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }


    /**
     * It fills given list
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
