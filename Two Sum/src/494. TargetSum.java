class Solution {
    Map<String, Integer> dp;

    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap();

        return helper(nums, target, 0, 0);

    }

    public int helper(int[] nums, int target, int index, int count) {
        if (index == nums.length) {
            if (target == 0)
                count += 1;
            return count;
        }
        if (index > nums.length) {
            return count;
        }

        if (dp.containsKey(target + ":" + index)) {
            return dp.get(target + ":" + index);
        }

        dp.put(target + ":" + index, helper(nums, target + nums[index], index + 1, 0)
                + helper(nums, target - nums[index], index + 1, 0));
        return dp.get(target + ":" + index);
    }
}
