class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0, dp);
    }

    public int helper(int[] arr, int k, int index, int[] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];

        int len = 1;
        int maxValue = 0;
        int resultValue = 0;

        for (int i = index; i < Math.min(arr.length, index + k); i++) {
            maxValue = Math.max(maxValue, arr[i]);
            int result = len * maxValue + helper(arr, k, i + 1, dp);
            resultValue = Math.max(result, resultValue);
            len++;
        }

        return dp[index] = resultValue;
    }
}
