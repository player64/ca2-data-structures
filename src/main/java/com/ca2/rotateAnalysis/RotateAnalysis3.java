package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericCollections;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

public class RotateAnalysis3 {
    public static void main(String[] args) {
        String[] tableHead = {
                "IList type",
                "IList.rotate()",
                "GenericCollections.rotate()",
                "GenericCollections.rotate2()",
                // "Avg time",
        };

        FileManagement file = new FileManagement("analysis3-7.md");
        int rotate = 5;

        for(int size = 10; size <= 1000; size*=2) {
            GenericArrayList<AnalysisCollection2> aCollection = new GenericArrayList<>();
            String title = "Generics with elements " + size + ". Rotated by " + rotate;
            AnalysisTable table = new AnalysisTable(title, tableHead);

            // analysis arrayList
            aCollection.add(
                    analysis("GenericArrayList", new GenericArrayList<>(), size)
            );

            // analysis linkedList
            aCollection.add(
                    analysis("GenericLinkedList", new GenericLinkedList<>(), size)
            );

            // GenericCollections.sort(aCollection);

            for (AnalysisCollection2 item : aCollection) {
                table.setCell(item.getName());
                table.setCell(item.getTime(0) + "μs");
                table.setCell(item.getTime(1) + "μs");
                table.setCell(item.getTime(2) + "μs");
                // table.setCell(String.valueOf(item.getAvgTime()));
            }
            //
            file.writeFile(table.produceTable());
        }
    }

    public static AnalysisCollection2 analysis(String name, IList<Integer> list, int size) {
        int ROTATE_BY = 5;
        long[] times = new long[3];
        Analysis analysis = new Analysis(list, size, ROTATE_BY);
        times[0] = analysis.rotate();
        times[1] = analysis.collectionsRotate();
        times[2] = analysis.collectionsRotate2();

        return new AnalysisCollection2(name, size, times);
    }
}
