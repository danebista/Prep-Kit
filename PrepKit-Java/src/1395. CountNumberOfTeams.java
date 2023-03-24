class Solution {
    public int numTeams(int[] nums) {
        int res=0;
        for (int i=0; i< nums.length; i++){
            int smallLeft=0;
            int largeLeft = 0;
            int smallRight=0;
            int largeRight=0;
            for (int j=i-1; j>=0; j--){
                if (nums[j]>nums[i]) largeLeft++;
                if (nums[j]<nums[i]) smallLeft++;
            }

            for (int j=i+1; j<nums.length; j++){
                if (nums[i]< nums[j]) largeRight++;
                if (nums[i]> nums[j]) smallRight++;
            }

            res+= smallLeft* largeRight + largeLeft * smallRight;
        }

        return res;
    }
}