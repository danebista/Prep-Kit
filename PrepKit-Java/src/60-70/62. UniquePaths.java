class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            }
        }

        return dp[m][n];
    }
}
