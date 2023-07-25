class Solution {
    Integer[][] dp;
    public int minSessions(int[] tasks, int sessionTime) {
        int n= tasks.length;
        dp = new Integer[(1 << 15)][16];
        return helper(tasks, n, sessionTime,0, 0);
    }

    public int helper(int[] tasks, int n, int sessionTime, int mask, int curr){
        if (mask == (1<<n)-1){
            return 1;
        }
        
        if(dp[mask][curr] != null){
            return dp[mask][curr];
        }

        int minimum = Integer.MAX_VALUE;
        for (int i=0; i< n; i++){
            if ((mask & (1<<i))==0){
                if (curr+tasks[i]<=sessionTime){
                    minimum = Math.min(minimum, helper(tasks, n, sessionTime, (mask| (1<<i)),curr+tasks[i]));
                }
                else {
                    minimum = Math.min(minimum, 1+helper(tasks, n , sessionTime, (mask|(1<<i)),tasks[i]));
                }
            }
        }

        return dp[mask][curr]= minimum;
    }
}
