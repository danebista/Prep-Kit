class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cuts1 = new int[cuts.length + 2];
        cuts1[0] = 0;
        cuts1[cuts1.length - 1] = n;
        int[][] dp = new int[cuts1.length][cuts1.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int i = 0; i < cuts.length; i++) {
            cuts1[i + 1] = cuts[i];
        }

        return helper(1, cuts1.length - 2, cuts1, dp);
    }

    public int helper(int i, int j, int[] cuts1, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            minCost = Math.min(minCost,
                    cuts1[j + 1] - cuts1[i - 1] + helper(i, k - 1, cuts1, dp) + helper(k + 1, j, cuts1, dp));
        }

        return dp[i][j] = minCost;
    }
}