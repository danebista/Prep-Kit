class Solution {
    long mod = (long)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
       
        long[][]dp = new long[locations.length+1][fuel+1];
        for (long[]d: dp){
            Arrays.fill(d, -1);
        }
        return (int)helper(start, finish, locations, fuel, dp);
    }

    public long helper(int start, int finish, int[]locations, int fuel, long[][]dp){
        if (fuel<0) return 0;
        long res=0;
        if (dp[start][fuel]!=-1) return dp[start][fuel];
        if (start==finish) res=1;
        for (int i=0; i<locations.length; i++){
            if (i==start) continue;
            res+=helper(i, finish, locations, fuel-Math.abs(locations[i]-locations[start]), dp);
        }

        return dp[start][fuel]=res%mod; 

    }


}
