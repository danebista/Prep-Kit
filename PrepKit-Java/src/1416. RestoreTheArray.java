class Solution {
    public int numberOfArrays(String s, int k) {
        if (s.charAt(0)=='0') return 0;
        int mod = (int)1e9+7;
        int[]dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0, s, k, dp);
    }
    public int helper(int index, String s, long k, int[]dp){
        if (index==s.length()) return 1;
        int mod = (int)1e9+7;
        long val=0;
        int res=0;
         if (s.charAt(index) == '0') return 0;
        if (dp[index]!=-1) return dp[index];
       
        for(int i=index; i<s.length(); i++){
            val=val*10 + (s.charAt(i)-'0');
            if (val>k) break;
            res+=helper(i+1, s, k, dp);
            res%=mod;
            
        }

        return dp[index]=res;
    }
}
