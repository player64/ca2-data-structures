package com.ca2.rotateAnalysis;

public class AnalysisTable {
    private final String head;
    private String body = "";
    private StringBuilder row;
    private final int rowSize;
    private int tempRowSize = 0;

    AnalysisTable(String title, String[] headNames) {
        rowSize = headNames.length;
        row = new StringBuilder();

        StringBuilder tempHead = new StringBuilder("# " + title);

        tempHead.append("\n| ");

        StringBuilder underHead = new StringBuilder("| ");

        for (String name : headNames) {
            tempHead.append(name).append(" | ");
            underHead.append("--- | ");
        }

        tempHead.append("\n");
        tempHead.append(underHead);
        head = tempHead.toString();
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    private void setRow(String row) {
        body += row;
    }

    public String produceTable() {
        return getHead() + getBody();
    }

    public void setCell(String cell) {
        if(tempRowSize == 0) {
            row.append("\n| ");
        }

        row.append(cell).append(" | ");
        tempRowSize++;
        if (tempRowSize == rowSize) {
            setRow(row.toString());
            row = new StringBuilder();
            tempRowSize = 0;
        }
    }
}
