class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(arr, 0, arr.length - 1, dp);
    }

    public int helper(int[] nums, int left, int right, int[][] dp) {

        if (left >= right)
            return 0;
        if (dp[left][right] != -1)
            return dp[left][right];

        int min = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int maxLeft = nums[left];
            int maxRight = nums[left + 1];
            for (int k = left; k <= i; k++) {
                maxLeft = Math.max(maxLeft, nums[k]);
            }
            for (int k = i + 1; k <= right; k++) {
                maxRight = Math.max(maxRight, nums[k]);
            }

            min = Math.min(min, maxLeft * maxRight + helper(nums, left, i, dp) + helper(nums, i + 1, right, dp));
        }

        return dp[left][right] = min;
    }
}
