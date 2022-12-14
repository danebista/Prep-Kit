class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int cmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            cmax = Math.max(cmax, nums[i]);
            if (cmax > nums[i + 2])
                return false;
        }

        return true;
    }
}
