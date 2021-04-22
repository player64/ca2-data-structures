package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;

import java.util.Random;

public class AnalysisListMethods {
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
        FileManagement file = new FileManagement("analysis-methods-8.md");

        for(int size = 100; size <= 10000; size *= 2) {
            int index = size / 2;


            String tableTitle = (size==100) ? "---" : "";
            AnalysisTable table = new AnalysisTable(tableTitle, tableHead);
            Analysis analysis;

            // analysis arrayList
            analysis = new Analysis(new GenericArrayList<>(), size, 0);

            table.setCell("GenericArrayList");
            table.setCell(analysis.add() + "μs");
            table.setCell(analysis.remove(index) + "μs");
            table.setCell(analysis.get(index) + "μs");
            table.setCell(analysis.set(index) + "μs");
            table.setCell(String.valueOf(size));
            table.setCell(String.valueOf(index));
            // analysis arrayList
            analysis = new Analysis(new GenericLinkedList<>(), size, 0);

            table.setCell("GenericLinkedList");
            table.setCell(analysis.add() + "μs");
            table.setCell(analysis.remove(index) + "μs");
            table.setCell(analysis.get(index) + "μs");
            table.setCell(analysis.set(index) + "μs");
            table.setCell(String.valueOf(size));
            table.setCell(String.valueOf(index));

            file.writeFile(table.produceTable());
        }

    }

    public static int generateRandomIndex(int size) {
        Random rand = new Random();
        return rand.nextInt(size);
    }
}
