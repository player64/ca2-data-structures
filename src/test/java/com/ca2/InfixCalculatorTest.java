package com.ca2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class InfixCalculatorTest {
    @Test
    void evaluate() throws Exception {
        assertEquals(2, InfixCalculator.evaluate("( ((  2 +  1 ) * 2) / 3  ) "));
        assertEquals(6, InfixCalculator.evaluate("( ( 12 * 5 )/ (11 - 1) )"));
        assertEquals(50, InfixCalculator.evaluate("(( 100 * 50 )/ 100)"));
    }

    @Test
    void evaluateWithWrongExpression() {
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
    void parseExpression()
    {
        GenericArrayList<String> list = InfixCalculator.parseExpression("( ( 1224 * 55555 ) / 6786 )");
        assertEquals(9, list.size());
        assertEquals("(", list.get(0));
        assertEquals("(", list.get(1));
        assertEquals("1224", list.get(2));
        assertEquals("*", list.get(3));
        assertEquals("55555", list.get(4));
        assertEquals(")", list.get(5));
        assertEquals("/", list.get(6));
        assertEquals("6786", list.get(7));
        assertEquals(")", list.get(8));
    }
}