class Solution {
    public static void convertToWave(int n, int[] nums) {
        // code here
        // write your code here
        for (int i=1; i< nums.length; i++){
            if (i%2==1 && nums[i]> nums[i-1]){
                swap(nums, i, i-1);
            }
            else if (i%2==0 && nums[i]< nums[i-1]){
                swap(nums, i, i-1);
            }
        }
    }

    public static void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
        
