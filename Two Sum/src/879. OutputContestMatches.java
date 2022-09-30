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

// Alternate Route

public class Solution {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n) {
        // write your code here
        return helper(n, n).get(0);
    }

    public List<String> helper(int n, int m) {
        List<String> result = new ArrayList();

        if (n <= 2) {
            for (int i = 0; i < m / 2; i++) {
                result.add("(" + (i + 1) + "," + (m - i) + ")");
            }
            return result;
        }
        List<String> values = helper(n / 2, m);

        for (int i = 0; i < values.size() / 2; i++) {
            String val = "(" + values.get(i) + "," + values.get(values.size() - i - 1) + ")";
            result.add(val);
        }

        return result;
    }
}
