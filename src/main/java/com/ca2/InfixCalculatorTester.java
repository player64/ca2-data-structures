package com.ca2;

import java.util.Scanner;

public class InfixCalculatorTester {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter infix expression:");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println("Result: " + InfixCalculator.evaluate(expression));
    }
}

