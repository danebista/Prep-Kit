//This solution only works for positive numbers;
class Solution {
    boolean[][] dp;

    public int minimumDifference(int[] nums) {
        if (nums.length == 2 && nums[0] == -nums[1])
            return Math.abs(nums[0] - nums[1]);
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        dp = new boolean[nums.length][totalSum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= totalSum)
            dp[0][nums[0]] = true;

        for (int index = 1; index < nums.length; index++) {
            for (int target = 1; target <= totalSum; target++) {
                boolean notPickCase = dp[index - 1][target];
                boolean pick = false;
                if (target - nums[index] >= 0) {
                    pick = dp[index - 1][target - nums[index]];
                }
                dp[index][target] = pick || notPickCase;
            }
        }

        int absDiff = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[dp.length - 1][i] == true) {
                absDiff = Math.min(absDiff, Math.abs((totalSum - i) - i));
            }
        }

        return absDiff;
    }
}
