class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount + 1];

        for (int am = 0; am <= amount; am++) {
            if (am % coins[0] == 0)
                dp[0][am] = 1;
        }

        for (int in = 1; in < coins.length; in++) {
            for (int am = 0; am <= amount; am++) {
                int notTake = dp[in - 1][am];
                int take = 0;
                if (am - coins[in] >= 0) {
                    take = dp[in][am - coins[in]];
                }
                dp[in][am] = take + notTake;
            }
        }
        return dp[coins.length - 1][amount];
    }
}
