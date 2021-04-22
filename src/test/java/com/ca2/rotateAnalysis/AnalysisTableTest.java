package com.ca2.rotateAnalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTableTest {
    private AnalysisTable table;

    @BeforeEach
    void setUp() {
        String[] headNames = {"Test1", "Test2"};
        table = new AnalysisTable("Test", headNames);
    }

    @Test
    void produceTable() {
        table.setCell("Test");
        table.setCell("Test2");
        table.setCell("Test3");
        table.setCell("Test4");

        String body = "\n| Test | Test2 | \n| Test3 | Test4 | ";

        assertEquals(expectedHead() + body, table.produceTable());
    }

    @Test
    void getHead() {
        assertEquals(expectedHead(), table.getHead());
    }

    @Test
    void getBody() {
        table.setCell("Test");
        table.setCell("Test2");
        table.setCell("Test3");
        table.setCell("Test4");
        assertEquals("\n| Test | Test2 | \n| Test3 | Test4 | ", table.getBody());
    }

    private String expectedHead() {
        String expectedString = "# Test";
        expectedString += "\n| Test1 | Test2 | \n";
        expectedString += "| --- | --- | ";

        return expectedString;
    }

    @Test
    void removeThisTest() {
        int max = 3;
        int min = 0;

        Random rand = new Random();
        for (int i = 0; i < 20; ++i) {
            int randomNum = rand.nextInt(max);
            System.out.println(randomNum);
        }
    }
}