class Solution {
    public void wiggleSort(int[] nums) {
        int[] numsRedo = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsRedo);
        int indx = nums.length - 1;
        for (int i = 1; i < nums.length; i = i + 2) {
            nums[i] = numsRedo[indx--];
        }
        for (int i = 0; i < nums.length; i = i + 2) {
            nums[i] = numsRedo[indx--];
        }
    }
}
