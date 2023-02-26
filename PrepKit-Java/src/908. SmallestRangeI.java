class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min= nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        if (min+k>=max-k) return 0;
        return max-min-2*k;// max-k-(min+k);
    }
}

