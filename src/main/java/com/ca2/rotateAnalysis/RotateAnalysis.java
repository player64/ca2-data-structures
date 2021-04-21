package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;
import java.util.ArrayList;
import java.util.LinkedList;

public class RotateAnalysis {
    public static void main(String[] args) {
        final int SIZE = 50;

        String[] tableHead = {
                "IList type",
                "Number of elements",
                "IList.rotate()",
                "GenericCollections.rotate()",
                "GenericCollections.rotate2()"
        };

        String[] tableHead2 = {
                "List type",
                "Number of elements",
                "Collections.rotate()",
        };
        FileManagement file = new FileManagement("analysis.md");
        for (int rotate = 1;  rotate < 11; ++rotate) {
            String title = "Generics rotated by " + rotate;

            AnalysisTable table = new AnalysisTable(title, tableHead);



            // analysis arrayList
            GenericArrayList<Integer> arrayList = new GenericArrayList<>();
            Analysis arrayListAnalysis = new Analysis(arrayList, SIZE, rotate);
            table.setCell("GenericArrayList");
            table.setCell(String.valueOf(SIZE));
            table.setCell(arrayListAnalysis.rotate() + "μs");
            table.setCell(arrayListAnalysis.collectionsRotate() + "μs");
            table.setCell(arrayListAnalysis.collectionsRotate2() + "μs");


            // analysis linkedList
            GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
            Analysis linkedListAnalysis = new Analysis(linkedList, SIZE, rotate);
            table.setCell("GenericLinkedList");
            table.setCell(String.valueOf(SIZE));
            table.setCell(linkedListAnalysis.rotate() + "μs");
            table.setCell(linkedListAnalysis.collectionsRotate() + "μs");
            table.setCell(linkedListAnalysis.collectionsRotate2() + "μs");

            // write results to file
            file.writeFile(table.produceTable());


            ArrayList<Integer> array = new ArrayList<>();
            LinkedList<Integer> linked = new LinkedList<>();

            title = "Java rotated by " + rotate;
            AnalysisTable table2 = new AnalysisTable(title, tableHead2);

            AnalysisJav arrayA = new AnalysisJav(array, SIZE, rotate);
            table2.setCell("ArrayList");
            table2.setCell(String.valueOf(SIZE));
            table2.setCell(arrayA.rotate() + "μs");

            AnalysisJav linkedA = new AnalysisJav(linked, SIZE, rotate);
            table2.setCell("LinkedList");
            table2.setCell(String.valueOf(SIZE));
            table2.setCell(linkedA.rotate() + "μs");
            file.writeFile(table2.produceTable());
        }

    }

}
