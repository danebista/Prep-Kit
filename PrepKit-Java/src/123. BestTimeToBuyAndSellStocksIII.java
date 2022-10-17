class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for (int i=0; i<prices.length;i++){
            for (int j=0; j<2; j++){
                for (int k=0; k<2; k++){
                    if (k==0){
                        dp[i][j][k]=0;
                    }
                    if (i==prices.length){
                        dp[i][j][k]=0;
                    }
                }
            }   
        }
        
        for(int i=prices.length-1; i>=0; i--){
            for (int j=0; j<2; j++){
                for (int k=1; k<=2; k++){
                    if (j==0){
                         dp[i][j][k] =  Math.max(-prices[i]+dp[i+1][1][k],
                            dp[i+1][0][k]);
                    }
                    else {
                        dp[i][j][k] = Math.max(prices[i]+ dp[i+1][0][k-1], 
                           dp[i+1][1][k]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
    
}
