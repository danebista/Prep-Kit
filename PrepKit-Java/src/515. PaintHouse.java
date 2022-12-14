public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int[][] dp = new int[costs.length + 1][3];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(costs, 0, -1, dp);
    }

    public int helper(int[][] costs, int index, int prev, int[][] dp) {
        if (index >= costs.length)
            return 0;
        int minCost = Integer.MAX_VALUE;
        if (prev != -1 && dp[index][prev] != -1)
            return dp[index][prev];

        for (int i = 0; i <= 2; i++) {
            if (i == prev)
                continue;
            minCost = Math.min(minCost, costs[index][i] + helper(costs, index + 1, i, dp));
        }
        if (prev != -1) {
            dp[index][prev] = minCost;
        }
        return minCost;
    }
}

// 滚动数组法优化空间
public class Solution {
    /*
     * @param costs: n x 3 cost matrix
     * 
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs.length == 0)
            return 0;

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}