class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(values, 1, values.length - 1, dp);
    }

    public int helper(int[] values, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int min_cost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            min_cost = Math.min(min_cost, values[i - 1] * values[k] * values[j] +
                    helper(values, i, k, dp) + helper(values, k + 1, j, dp));

        }

        return dp[i][j] = min_cost;

    }
}
