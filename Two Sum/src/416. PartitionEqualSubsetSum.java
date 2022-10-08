public boolean helper(int[]nums, int index, int target){
    if(index == 0){
        return nums[0]==target;
    }
    if (target ==0) return true;
    if (dp[index][target]!=null) return dp[index][target];
    
    boolean notTake = helper(nums, index-1, target);
    boolean take = false;
    if (target-nums[index]>=0){
        take = helper(nums, index-1, target-nums[index]);
    }
    dp[index][target] = take || notTake;
    return dp[index][target];
    
}
