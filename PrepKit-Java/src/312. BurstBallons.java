class Solution {
    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length + 2];

        nums1[0] = 1;
        nums1[nums1.length - 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            nums1[i + 1] = nums[i];
        }

        int[][] dp = new int[nums1.length + 1][nums1.length + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(nums1, 1, nums1.length - 2, dp);
    }

    public int helper(int[] nums1, int i, int j, int[][] dp) {

        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.max(max,
                    nums1[i - 1] * nums1[k] * nums1[j + 1]
                            + helper(nums1, i, k - 1, dp) + helper(nums1, k + 1, j, dp));
        }

        return dp[i][j] = max;
    }
}
