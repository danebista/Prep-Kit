public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs.length == 0)
            return 0;
        if (costs.length == 1 && costs[0].length == 1)
            return costs[0][0];
        int[][] dp = new int[costs.length + 1][costs[0].length + 1];
        int max_min = Integer.MAX_VALUE;
        for (int i = 0; i <= costs[0].length - 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int prev = 0; prev <= costs[0].length - 1; prev++) {

                if (i == prev)
                    continue;
                min = Math.min(min, costs[0][prev]);
            }
            dp[0][i] = min;
            max_min = Math.min(max_min, dp[0][i]);
        }

        if (costs.length == 1)
            return max_min;

        for (int index = 1; index < costs.length; index++) {
            for (int prev = 0; prev <= costs[0].length; prev++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < costs[0].length; i++) {
                    if (prev == i)
                        continue;
                    min = Math.min(min, costs[index][i] + dp[index - 1][i]);
                }
                dp[index][prev] = min;
            }
        }
        return dp[costs.length - 1][costs[0].length];
        // return helper(costs, costs.length-1, costs[0].length, costs[0].length, dp);
    }

    public int helper(int[][] costs, int index, int k, int prev, int[][] dp) {

        if (index == 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {

            }
            return min;
        }
        if (dp[index][prev] != -1)
            return dp[index][prev];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (prev == i)
                continue;
            min = Math.min(min, costs[index][i] + helper(costs, index - 1, k, i, dp));
        }

        return dp[index][prev] = min;
    }
}