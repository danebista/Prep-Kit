class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(helper(nums, 1, nums.length - 1),
                helper(nums, 0, nums.length - 2));
    }

    public int helper(int[] nums, int start, int i) {

        if (i < start)
            return 0;

        int left = nums[i] + (i - 2 >= start ? helper(nums, start, i - 2) : 0);
        int right = (i - 1 >= start ? helper(nums, start, i - 1) : 0);

        return Math.max(left, right);
    }
}
