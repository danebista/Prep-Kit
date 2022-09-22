class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while (j >= 0 && nums[j + 1] <= nums[j]) {
            j--;
        }
        if (j < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int i = nums.length - 1;
        while (nums[j] >= nums[i])
            i--;
        swap(nums, i, j);
        reverse(nums, j + 1, nums.length - 1);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
