class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int steps = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i]){
                steps++;
                nums[i] = nums[i-1]+1;
            }
            if(nums[i-1] > nums[i]){
                steps = steps + nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1]+1;
            }
        }
        return steps;
    }
}
