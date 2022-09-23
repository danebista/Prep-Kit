import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (c == ')'
                    && !stack.isEmpty()
                    && stack.peek() == '(') {
                stack.pop();
            }

            else if (c == ']'
                    && !stack.isEmpty()
                    && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}'
                    && !stack.isEmpty()
                    && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
