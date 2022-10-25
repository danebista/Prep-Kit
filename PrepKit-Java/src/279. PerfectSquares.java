class Solution {
    public int numSquares(int n) {
        // return helper(n);
        int[] dp = new int[n + 1];
        for (int target = 1; target <= n; target++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= target; i++) {
                if (target - i * i < 0)
                    break;
                min = Math.min(min, 1 + dp[target - i * i]);
            }
            dp[target] = min;
        }

        return dp[n];
    }
}
