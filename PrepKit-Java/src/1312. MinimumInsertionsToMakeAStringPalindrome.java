class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s1 = sb.toString();
        int[][] dp = new int[s.length()][s.length()];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int lcs = findLCS(s, s1, s.length() - 1, s.length() - 1, dp);

        return s.length() - lcs;
    }

    public int findLCS(String s, String s1, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s1.charAt(j)) {
            return dp[i][j] = 1 + findLCS(s, s1, i - 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(findLCS(s, s1, i, j - 1, dp), findLCS(s, s1, i - 1, j, dp));
    }
}
