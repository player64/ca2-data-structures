package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

public class AnalysisListMethods {
    /**
     * It generates md file on run with methods analysis
     */
    public static void main(String[] args) {
        String[] tableHead = {
                "List type",
                "add",
                "remove",
                "get",
                "set",
                "No of elements",
                "Index used for remove get set"
        };

        FileManagement file = new FileManagement("analysis-methods.md");

        for(int size = 100; size <= 10000; size *= 2) {
            int index = size - 1;


            String tableTitle = (size==100) ? "---" : "";

            AnalysisTable table = new AnalysisTable(tableTitle, tableHead);

            analyse("GenericArrayList", table, size, index);
            analyse("GenericLinkedList", table, size, index);

            file.writeFile(table.produceTable());
        }

    }

    /**
     * Set the table
     * @param name provide GenericArrayList or GenericLinkedList
     * @param table add the AnalysisTable
     * @param size int size of the list
     * @param index int number of index to perform get, set and delete
     */
    public static void analyse(String name, AnalysisTable table, int size, int index) {
        IList<Integer> list;

        if(name.equals("GenericArrayList")) {
            list = new GenericArrayList<>();
        } else if (name.equals("GenericLinkedList")) {
            list = new GenericLinkedList<>();
        } else {
            throw new IllegalArgumentException();
        }

        Analysis analysis = new Analysis(list, size);

        table.setCell(name);
        table.setCell(analysis.add() + "μs");
        table.setCell(analysis.remove(index) + "μs");
        table.setCell(analysis.get(index) + "μs");
        table.setCell(analysis.set(index) + "μs");
        table.setCell(String.valueOf(size));
        table.setCell(String.valueOf(index));
    }
}
