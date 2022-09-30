public class Solution {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    String[] match;

    public String findContestMatch(int n) {
        // write your code here
        match = new String[n];
        for (int i = 0; i < n; i++) {
            match[i] = (i + 1) + "";
        }
        helper(n);
        return match[0];
    }

    public void helper(int n) {
        if (n <= 1)
            return;

        for (int i = 0; i < n / 2; i++) {
            match[i] = "(" + match[i] + "," + match[n - i - 1] + ")";
        }
        helper(n / 2);
    }
}
