class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k+1];
        for (double[]d:dp){
            Arrays.fill(d, -1);
        }
        return helper(nums, k, 0, dp);
    }

    public double helper(int[] nums, int k, int index, double[][]dp){
        if (index>=nums.length ) return 0;
        double answer =0;
        double sum = 0;
        if (dp[index][k]!=-1) return dp[index][k];
        if (k == 1) {  
            for (int i=index; i<nums.length; i++){
                sum+=nums[i];
            }
            return dp[index][k]=(double)sum/(nums.length-1-index+1) ;
        }
        

        for (int i=index; i< nums.length; i++){
            sum +=nums[i];
            double val = sum/(i-index+1);
            answer = Math.max(answer, val + helper(nums, k-1, i+1, dp));
        }

        return dp[index][k]=answer;
    }
}
