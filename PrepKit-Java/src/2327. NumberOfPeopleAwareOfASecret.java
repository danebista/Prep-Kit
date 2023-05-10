class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[1001];
        Arrays.fill(dp,-1);
        return helper(1, n, delay, forget, dp);
    }

    public int helper(int day, int n, int d, int f, int[]dp){
        if (dp[day]!=-1) return dp[day];

        int mod =(int) 1e9+7;
        int ans =0;
        ans++;
        if (day+f<=n){
            ans--;
        }

        for (int i=day+d; i<Math.min(day+f, n+1); i++){
            ans+= helper(i, n, d, f, dp);
            ans = ans%mod;
        }
 
        return dp[day] = ans%mod;
    }
}
