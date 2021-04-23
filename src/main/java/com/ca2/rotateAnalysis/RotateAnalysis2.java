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
                "IList.rotate()",
                "GenericCollections.rotate()",
                "GenericCollections.rotate2()",
                "Number of elements",

        };

        String[] tableHead2 = {
                "List type",
                "Number of elements",
                "Collections.rotate()",
        };
        FileManagement file = new FileManagement("analysis64-2.md");
        //for (int rotate = -10; rotate < 11; ++rotate)
        int rotate = 10;
        {

            for(int size = 10; size <= 100000; size*=2) {
                String title = "Generics rotated by " + rotate;
                GenericArrayList<AnalysisCollection> aCollection = new GenericArrayList<>();
                AnalysisTable table = new AnalysisTable(title, tableHead);
                // analysis arrayList
                GenericArrayList<Integer> arrayList = new GenericArrayList<>();
                Analysis arrayListAnalysis = new Analysis(arrayList, size);

                aCollection.add(new AnalysisCollection("GenericArrayList", arrayListAnalysis.collectionsRotate(rotate), size));

                // lined list
                GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();
                Analysis linkedListAnalysis = new Analysis(linkedList, size);
                aCollection.add(new AnalysisCollection("GenericLinkedList", linkedListAnalysis.collectionsRotate(rotate), size));

                // arrayList
                ArrayList<Integer> jArrayList = new ArrayList<>();
                AnalysisJav jArrayListA = new AnalysisJav(jArrayList, size, rotate);
                aCollection.add(new AnalysisCollection("ArrayList", jArrayListA.rotate(), size));

                //
                LinkedList<Integer> jLinkedList = new LinkedList<>();
                AnalysisJav jLinkedListA = new AnalysisJav(jLinkedList, size, rotate);
                aCollection.add(new AnalysisCollection("LinkedList", jLinkedListA.rotate(), size));

                // GenericCollections.sort(aCollection);

                for (AnalysisCollection item : aCollection) {
                    table.setCell(item.getName());
                    table.setCell(item.getTime() + "μs");
                    table.setCell(String.valueOf(item.getNoOfElements()));
                }
                //
                file.writeFile(table.produceTable());

            }


        }
    }
}
