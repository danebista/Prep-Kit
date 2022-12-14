class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int max = 0;
            for (int j = left; j <= right; j++) {

                max = Math.max(max, j + nums[j]);
            }
            left = right + 1;
            right = max;
            jumps += 1;
        }

        return jumps;
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
