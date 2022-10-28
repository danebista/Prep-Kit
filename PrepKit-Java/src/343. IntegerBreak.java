class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int out = 3; out <= n; out++) {
            for (int i = 1; i <= out / 2; i++) {
                int val = Math.max(i, dp[i]) * Math.max(out - i, dp[out - i]);
                dp[out] = Math.max(dp[out], val);
            }
        }
        return dp[n];
    }
}
