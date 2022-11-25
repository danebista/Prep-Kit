class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int l, int r, int k) {
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= nums[r]) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p += 1;
            }
        }
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;

        if (p > k)
            return quickSelect(nums, l, p - 1, k);
        else if (p < k)
            return quickSelect(nums, p + 1, r, k);
        else
            return nums[p];
    }
}
