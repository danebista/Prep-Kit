class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = 1;
        int max = 1;
        for (int i=1; i< nums.length; i++){
            if (nums[i]> nums[i-1]){
                length+=1;
            }
            else{
                length=1;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
