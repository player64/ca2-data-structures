package com.ca2.rotateAnalysis;

/**
 *
 */
public class AnalysisCollection implements Comparable<AnalysisCollection> {
    private final String name;
    private final int noOfElements;
    private final long time;

    public AnalysisCollection(String name, long time, int noOfElements) {
        this.name = name;
        this.noOfElements = noOfElements;
        this.time = time;
    }

    @Override
    public int compareTo(AnalysisCollection o) {
        return Long.compare(time, o.time);
    }

    public String getName() {
        return name;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public long getTime() {
        return time;
    }
}
