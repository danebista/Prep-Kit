class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int maxLenForward = 0;
        int maxLenBackward = 0;
        int close = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            ;
            if (open == close) {
                maxLenForward = Math.max(maxLenForward, close + open);
            }
            if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            ;
            if (open == close) {
                maxLenBackward = Math.max(maxLenBackward, close + open);
            }
            if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return Math.max(maxLenForward, maxLenBackward);
    }
}
