class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);

    }

    public int helper(int[] nums, int i, int[] dp) {
        if (i >= nums.length - 1)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int minCost = nums.length;

        for (int k = 1; k <= nums[i]; k++) {
            minCost = Math.min(minCost, 1 + helper(nums, i + k, dp));
        }

        return dp[i] = minCost;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];

        return helper(nums, 0, dp);

    }

    public boolean helper(int[] nums, int i, Boolean[] dp) {
        if (i >= nums.length - 1)
            return true;

        if (dp[i] != null)
            return dp[i];

        boolean check = false;
        for (int k = 1; k <= Math.min(nums[i], nums.length - 1); k++) {
            check = check || helper(nums, i + k, dp);
        }

        return dp[i] = check;
    }
}
