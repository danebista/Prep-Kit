import java.util.*;

class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        generateValidParanthesis(0, 0, "", n);

        return result;
    }

    public void generateValidParanthesis(int open, int close, String ans, int n) {
        if (ans.length() == n * 2) {
            result.add(ans);
            return;
        }
        if (open < n)
            generateValidParanthesis(open + 1, close, ans + '(', n);
        if (open > close)
            generateValidParanthesis(open, close + 1, ans + ')', n);

    }
}
