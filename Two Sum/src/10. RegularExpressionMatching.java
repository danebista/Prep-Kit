class Solution {
    Boolean[][] cache;

    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return regularExpressionMatcher(s, p, 0, 0);
    }

    public boolean regularExpressionMatcher(String s, String p, int i, int j) {
        if (cache[i][j] != null)
            return cache[i][j];
        if (i >= s.length() && j >= p.length()) {
            cache[i][j] = true;
            return cache[i][j];
        }
        if (j >= p.length())
            return cache[i][j] = false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean result = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = (match && regularExpressionMatcher(s, p, i + 1, j)) ||
                    regularExpressionMatcher(s, p, i, j + 2);
        } else if (match) {
            result = regularExpressionMatcher(s, p, i + 1, j + 1);
        }
        cache[i][j] = result;

        return cache[i][j];
    }
}
