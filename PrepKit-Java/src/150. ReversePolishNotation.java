class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operator = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")) {
                int calculateValue = calculate(tokens[i], operator.pop(), operator.pop());
                operator.push(calculateValue);
            } else {
                int inte = Integer.valueOf(tokens[i]);
                operator.push(inte);
            }
        }
        return operator.pop();
    }

    public int calculate(String token, Integer operand1, Integer operand2) {
        if (token.equals("+")) {
            return operand1 + operand2;
        }
        if (token.equals("-")) {
            return operand2 - operand1;
        }
        if (token.equals("*")) {
            return operand2 * operand1;
        }

        return operand2 / operand1;
    }
}
