package com.ca2;

class InfixCalculator {
    public static double evaluate(String expression) throws Exception {
        // remove all whitespaces
        expression = InfixCalculator.removeWhiteSpaces(expression);

        // test expression does it start with ( and ends with )
        if(!expression.matches("^\\(.*\\)$")) {
            throw new Exception("Infix calculator must starts with ( and ends with )");
        }

        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> operands = new GenericStack<>();

        // convert to array each part of expression
        String[] expressionParts = InfixCalculator.convertExpressionToArray(expression);

        for (String part : expressionParts) {
            switch (part) {
                case ("("):
                    break;
                case ("+"):
                case ("-"):
                case ("*"):
                case ("/"):
                    operators.push(part);
                    break;
                case (")"):
                    double nextOperands = operands.pop();
                    double prevOperands = operands.pop();
                    double result = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("+") -> result = prevOperands + nextOperands;
                        case ("-") -> result = prevOperands - nextOperands;
                        case ("*") -> result = prevOperands * nextOperands;
                        case ("/") -> result = prevOperands / nextOperands;
                    }
                    operands.push(result);
                    break;
                default:
                    // prevent adding non numeric parts
                    try {
                        operands.push(Double.parseDouble(part));
                    } catch (NumberFormatException e) {
                        System.out.println(part + " it's not a number omitting");
                        continue;
                    }
                    break;
            }
        }

        return operands.pop();
    }

    public static String removeWhiteSpaces(String expression) {
        return expression.replaceAll("\\s+", "");
    }

    public static String[] convertExpressionToArray(String expression) {
        return expression.split("");
    }

    public static GenericArrayList<String> parseExpression(String expression) {
        GenericArrayList<String> output = new GenericArrayList<>();
        for(char i : expression.toCharArray()) {
            output.add(String.valueOf(i));
        }
        return output;
    }
}
