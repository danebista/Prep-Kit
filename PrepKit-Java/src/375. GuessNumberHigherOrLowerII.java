class Solution {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(1, n, dp);
    }

    public int helper(int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;

        for (int m = i; m <= j; m++) {
            min = Math.min(min, m + Math.max(helper(i, m - 1, dp), helper(m + 1, j, dp)));
        }

        return dp[i][j] = min;
    }
}
