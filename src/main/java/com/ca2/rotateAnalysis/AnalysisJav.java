package com.ca2.rotateAnalysis;

import com.ca2.IList;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnalysisJav {
    private final List<Integer> list;
    private final int size;
    private final int distance;

    public AnalysisJav(List<Integer> list, int size, int distance) {
        this.list = list;
        this.size = size;
        this.distance = distance;
        fillList();
    }

    public long rotate() {
        Timer timer = new Timer();
        timer.start();
        Collections.rotate(list,distance);
        timer.stop();

        return convertTimeToMicroSeconds(timer.getElapsedTime());
    }

    private void fillList() {
        for(int i = 0; i <= size; ++i) {
            list.add(i);
        }
    }

    private long convertTimeToMicroSeconds(long time) {
        return TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
