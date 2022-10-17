class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int m = 0; m < k; m++) {
                    if (m == 0) {
                        dp[i][j][m] = 0;
                    }
                    if (i == prices.length) {
                        dp[i][j][m] = 0;
                    }
                }
            }
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int m = 1; m <= k; m++) {
                    if (j == 0) {
                        dp[i][j][m] = Math.max(-prices[i] + dp[i + 1][1][m],
                                dp[i + 1][0][m]);
                    } else {
                        dp[i][j][m] = Math.max(prices[i] + dp[i + 1][0][m - 1],
                                dp[i + 1][1][m]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}
