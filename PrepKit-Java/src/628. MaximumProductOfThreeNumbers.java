public class 628. MaximumProductOfThreeNumbers {
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int max = Math.max(nums[0] * nums[1]* nums[nums.length-1], nums[nums.length-1]* nums[nums.length-2]
            * nums[nums.length-3]);
    
            return max;
        }
    }
}
