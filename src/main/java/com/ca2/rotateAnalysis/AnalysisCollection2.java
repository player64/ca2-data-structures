package com.ca2.rotateAnalysis;

public class AnalysisCollection2  implements Comparable<AnalysisCollection2> {
    private final String name;
    private final int noOfElements;
    private final long[] times;
    private final long avgTime;

    public AnalysisCollection2(String name, int noOfElements, long[] times) {
        this.name = name;
        this.noOfElements = noOfElements;
        this.times = times;

        long avg = 0;
        for (int i = 0; i < times.length; i++) {
            avg+=times[i];
        }
        avgTime = avg / times.length;
    }


    @Override
    public int compareTo(AnalysisCollection2 o) {
        return Long.compare(avgTime, o.avgTime);
    }


    public String getName() {
        return name;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public long[] getTimes() {
        return times;
    }

    public long getTime(int index) {
        if(index < 0 || index >= times.length) {
            throw new IndexOutOfBoundsException();
        }
        return times[index];
    }

    public long getAvgTime() {
        return avgTime;
    }
}
