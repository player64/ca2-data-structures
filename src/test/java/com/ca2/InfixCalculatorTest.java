package com.ca2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InfixCalculatorTest {
    @Test
    void evaluate() throws Exception {
        // assertEquals(2, InfixCalculator.evaluate("( ((  2 +  1 ) * 2) / 3  ) "));
        assertEquals(10, InfixCalculator.evaluate("( ( 12 * 5 ) / 6 )"));
    }

    @Test
    void evaluateWithWrongExpressions() throws Exception {
        String test = "1+23+4";
        assertThrows(Exception.class, () -> InfixCalculator.evaluate(test));
    }

    @Test
    void removeWhiteSpaces() {
        String testExpression = " (  2 +  1 ) * 2 / 3   ";
        String removedSpaces = InfixCalculator.removeWhiteSpaces(testExpression);
        assertEquals("(2+1)*2/3", removedSpaces);
    }

    @Test
    void convertExpressionToArray() {
        String testExpression = "(2+1)*2/3";
        String[] arrayOfTestExpression = InfixCalculator.convertExpressionToArray(testExpression);

        assertEquals(9, arrayOfTestExpression.length);
        assertEquals("(", arrayOfTestExpression[0]);
        assertEquals("2", arrayOfTestExpression[1]);
        assertEquals("+", arrayOfTestExpression[2]);
        assertEquals("1", arrayOfTestExpression[3]);
        assertEquals(")", arrayOfTestExpression[4]);
        assertEquals("*", arrayOfTestExpression[5]);
        assertEquals("2", arrayOfTestExpression[6]);
        assertEquals("/", arrayOfTestExpression[7]);
        assertEquals("3", arrayOfTestExpression[8]);
    }

    @Test
    void parseExpression()
    {
        GenericArrayList<String> list = InfixCalculator.parseExpression("( ( 12 * 5 ) / 6 )");

        for (String l : list) {
            System.out.println(l);
        }
    }
}