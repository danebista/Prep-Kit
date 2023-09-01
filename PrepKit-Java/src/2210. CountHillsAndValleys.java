class Solution {
    public int countHillValley(int[] nums) {
        int count =0;
        for(int i=1; i<nums.length-1; i++) {
            int j = i;
            while (j<nums.length-2 && nums[j] == nums[j+1]) {
                j++;
            }
            if ((nums[i-1] < nums[i] && nums[i] > nums[j+1]) || (nums[i-1] > nums[i] && nums[i] < nums[j+1])) {
                count++;
            }
            i = j;
        }
        return count;
    }
}
