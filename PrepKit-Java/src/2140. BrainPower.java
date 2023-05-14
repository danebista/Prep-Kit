class Solution {
    public long mostPoints(int[][] questions) {
        long []dp = new long[questions.length];
        Arrays.fill(dp,-1);
        return helper(0,questions, dp);
    }

    public long helper(int index, int[][]questions, long[] dp){
        if (index>=questions.length){
            return 0;
        }
        if (dp[index]!=-1) return dp[index]; 
 
        long take= questions[index][0] + helper(index+questions[index][1]+1, questions, dp);
        long notTake= 0+ helper(index+1, questions, dp);

        return dp[index]= Math.max(take,notTake);
    }
}
