package com.ca2.rotateAnalysis;

import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;
import com.ca2.IList;

/**
 * It generates md file on run with rotate analysis
 */
public class RotateAnalysis {
    private static final int ROTATE_BY = 5;

    public static void main(String[] args) {

        String[] tableHead = {
                "IList type",
                "Rotated by",
                "Number of elements",
                "IList.rotate()",
                "GenericCollections.rotate()",
                "GenericCollections.rotate2()",
        };

        // Set the file
        FileManagement file = new FileManagement("analysis-rotate.md");

        for (int size = 10;  size < 1300; size *= 2) {
            AnalysisTable table = new AnalysisTable("", tableHead);
            analyse("GenericArrayList", table, size);
            analyse("GenericLinkedList", table, size);

            // write results to file
            file.writeFile(table.produceTable());
        }
    }

    /**
     * Set the table
     * @param name provide GenericArrayList or GenericLinkedList
     * @param table add the AnalysisTable
     * @param size int size of the list
     */
    public static void analyse(String name, AnalysisTable table, int size) {
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
        table.setCell(String.valueOf(ROTATE_BY));
        table.setCell(String.valueOf(size));
        table.setCell(analysis.rotate(ROTATE_BY) + "μs");
        table.setCell(analysis.collectionsRotate(ROTATE_BY) + "μs");
        table.setCell(analysis.collectionsRotate2(ROTATE_BY) + "μs");
    }

}
