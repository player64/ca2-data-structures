package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericCollections;
import com.ca2.GenericLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class RotateAnalysis2 {
    public static void main(String[] args) {
        final int SIZE = 50;

        String[] tableHead = {
                "IList type",
                "Number of elements",
                "rotate execution time",
        };

        String[] tableHead2 = {
                "List type",
                "Number of elements",
                "Collections.rotate()",
        };
        FileManagement file = new FileManagement("analysis64.md");
        for (int rotate = -10; rotate < 11; ++rotate) {
            String title = "Generics rotated by " + rotate;

            AnalysisTable table = new AnalysisTable(title, tableHead);

            GenericArrayList<AnalysisCollection> aCollection = new GenericArrayList<>();

            // analysis arrayList
            GenericArrayList<Integer> arrayList = new GenericArrayList<>();
            Analysis arrayListAnalysis = new Analysis(arrayList, SIZE, rotate);

            aCollection.add(new AnalysisCollection("GenericArrayList", arrayListAnalysis.rotate(), SIZE));

            // lined list
            GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
            Analysis linkedListAnalysis = new Analysis(linkedList, SIZE, rotate);
            aCollection.add(new AnalysisCollection("GenericLinkedList", linkedListAnalysis.rotate(), SIZE));

            // arrayList
            ArrayList<Integer> jArrayList = new ArrayList<>();
            AnalysisJav jArrayListA = new AnalysisJav(jArrayList, SIZE, rotate);
            aCollection.add(new AnalysisCollection("ArrayList", jArrayListA.rotate(), SIZE));

            //
            LinkedList<Integer> jLinkedList = new LinkedList<>();
            AnalysisJav jLinkedListA = new AnalysisJav(jLinkedList, SIZE, rotate);
            aCollection.add(new AnalysisCollection("LinkedList", jLinkedListA.rotate(), SIZE));

            GenericCollections.sort(aCollection);

            for (AnalysisCollection item : aCollection) {
                table.setCell(item.getName());
                table.setCell(item.getTime() + "μs");
                table.setCell(String.valueOf(item.getNoOfElements()));
            }

            file.writeFile(table.produceTable());
        }
    }
}
