package com.ca2.rotateAnalysis;

/**
 * It build the table in md file format
 */
public class AnalysisTable {
    private final String head;
    private String body = "";
    private StringBuilder row;
    private final int rowSize;
    private int tempRowSize = 0;

    /**
     * Builds the table head
     * @param title String
     * @param headNames String[]
     */
    AnalysisTable(String title, String[] headNames) {
        rowSize = headNames.length;
        row = new StringBuilder();
        StringBuilder tempHead = new StringBuilder();

        if(!title.equals("")) {
            tempHead.append("# ").append(title);
        }

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

    /**
     * Getting the head of the table
     * @return String
     */
    public String getHead() {
        return head;
    }

    /**
     * Getting the table body
     * @return String
     */
    public String getBody() {
        return body;
    }

    /**
     * Setting the row
     * @param row String
     */
    private void setRow(String row) {
        body += row;
    }

    /**
     * Returns the whole table
     * @return String
     */
    public String produceTable() {
        return getHead() + getBody();
    }

    /**
     * Setting the table cell
     * @param cell String
     */
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
