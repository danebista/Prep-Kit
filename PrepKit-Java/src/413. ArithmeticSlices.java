class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int ways = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 0;
            }
            ways += dp[i];
        }

        return ways;
    }
}