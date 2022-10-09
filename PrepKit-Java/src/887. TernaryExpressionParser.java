public class Solution {
    /**
     * @param expression: a string, denote the ternary expression
     * @return: a string
     */
    public String parseTernary(String expression) {
        // write your code here
        Stack<Integer> stack = new Stack();
        List<Character> exp = new ArrayList();

        for (int i = 0; i < expression.length(); i++) {
            exp.add(expression.charAt(i));
            if (expression.charAt(i) == '?')
                stack.push(i);
        }

        while (!stack.isEmpty()) {
            int in = stack.pop();
            int bool = in - 1;
            int truth = in + 1;
            int second = in + 3;
            char res = cal(exp, bool, truth, second);
            // System.out.println(first);
            for (int i = second; i >= bool; i--) {
                exp.remove(i);
            }
            exp.add(bool, res);
        }

        return String.valueOf(exp.get(0));
    }

    private Character cal(List<Character> exp, int bool, int truth, int second) {
        if (exp.get(bool) == 'T') {
            return exp.get(truth);
        } else {
            return exp.get(second);
        }
    }
}
