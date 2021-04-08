package com.ca2;

class InfixCalculator {
    /**
     * It calculate infix expression from given string
     *
     * @param expression string must starts with ( ends with )
     * @return result of the
     * @throws Exception if the expression doesn't start with ( and ends with )
     */
    public static double evaluate(String expression) throws Exception {
        // remove all whitespaces
        expression = InfixCalculator.removeWhiteSpaces(expression);

        // test expression does it start with ( and ends with )
        if (!expression.matches("^\\(.*\\)$")) {
            throw new Exception("Infix calculator must starts with ( and ends with )");
        }

        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> operands = new GenericStack<>();

        // convert to array each part of expression
        GenericArrayList<String> expressionParts = InfixCalculator.parseExpression(expression);

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
                    double rightOperands = operands.pop();
                    double leftOperands = operands.pop();
                    double result = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("+") -> result = leftOperands + rightOperands;
                        case ("-") -> result = leftOperands - rightOperands;
                        case ("*") -> result = leftOperands * rightOperands;
                        case ("/") -> result = leftOperands / rightOperands;
                    }
                    operands.push(result);
                    break;
                default:
                    // prevent adding non numeric parts
                    try {
                        operands.push(Double.parseDouble(part));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(part + " it's not a number omitting");
                        break;
                    }

            }
        }
        return operands.pop();
    }

    /**
     * Removes all spaces from the expression
     *
     * @param expression raw expression
     * @return String with no spaces
     */
    public static String removeWhiteSpaces(String expression) {
        return expression.replaceAll("\\s+", "");
    }

    /**
     * It walks through each character in expression if character is numeric it appends
     * to string builder. It's used to avoid a situation if expression holds for example 12 it pushes
     * 12 rather than [1,2]
     *
     * @param expression raw expression
     * @return GenericArrayList<String>
     */
    public static GenericArrayList<String> parseExpression(String expression) {
        GenericArrayList<String> list = new GenericArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= expression.length() - 1; i++) {
            char character = expression.charAt(i);

            if (Character.isWhitespace(character)) {
                // removes whitespace the method removeWhiteSpaces is called at evaluate, however, this one is used
                // for tests
                continue;
            }

            if (Character.isDigit(character)) {
                // push numeric character to string builder
                sb.append(character);
            } else {
                // it's not a number
                // add collection of numbers in StringBuilder if not empty to ArrayList & reset stringBuilder
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }

                // add operators to GenericArrayList
                list.add(String.valueOf(character));
            }
        }
        return list;
    }
}
