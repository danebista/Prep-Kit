class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        
        for (int index=1;index<=strs.length; index++){
            for (int k=0; k<=m;k++){
                for (int l=0; l<=n; l++){
                    int countZeros = countZeros(strs[index-1]);
                    int countOnes = strs[index-1].length()-countZeros;
                    int take = Integer.MIN_VALUE;
                    if (countZeros<=k && countOnes<=l){
                        take =1+dp[index-1][k-countZeros][l-countOnes];
                    }
                    dp[index][k][l]=Math.max(take,dp[index-1][k][l]);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int helper(String[] strs, int index, int m , int n, int[][][] dp){

        //System.out.println(index);
        if (index<0){
            return 0;
        }

        
        if (dp[index][m][n]!=-1) return dp[index][m][n];
      
        int countZeros = countZeros(strs[index]);
    
        int countOnes = strs[index].length()-countZeros;
      
        int take = Integer.MIN_VALUE;
        if (countZeros<=m && countOnes<=n){
            take =1+helper(strs, index-1, m-countZeros, n-countOnes, dp);
        }

        return dp[index][m][n]=Math.max(take,helper(strs, index-1, m, n, dp));
    }

    public int countZeros(String s){
        int countZero =0;
        for (int i=0; i< s.length(); i++){
            if (s.charAt(i)=='0') countZero++;
        }
        return countZero;
    }

}
