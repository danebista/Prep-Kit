class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][]dp= new long[nums.length+1][3];
        for (int index=1; index<=nums.length; index++){
            for (int flag=0; flag<3; flag++){
                long take = 0;
                if (flag==0){
                    take = nums[index-1]+dp[index-1][1];
                }

                if (flag==1){
                    take = -nums[index-1]+dp[index-1][2];
                }

                if (flag==2){
                    take = nums[index-1]+dp[index-1][1];
                }

                long notTake = dp[index-1][flag];

                dp[index][flag]= Math.max(take, notTake);
            }
        }

        return dp[nums.length][0];
    }
}
