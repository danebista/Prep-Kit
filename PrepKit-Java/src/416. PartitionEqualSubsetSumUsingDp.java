class Solution {
    boolean curr[];

    public boolean canPartition(int[] nums) {
        int numSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
        }

        if (numSum % 2 == 1)
            return false;
        curr = new boolean[numSum / 2 + 1];
        int k = numSum / 2;
        boolean[] prev = new boolean[numSum / 2 + 1];
        curr[0] = true;
        prev[0] = true;

        if (nums[0] <= k)
            prev[nums[0]] = true;

        for (int index = 1; index < nums.length; index++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target - nums[index] >= 0) {
                    take = prev[target - nums[index]];
                }
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        return prev[k];
    }

}
