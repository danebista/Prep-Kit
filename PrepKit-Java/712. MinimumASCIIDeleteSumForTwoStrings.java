class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][]dp = new int[s1.length()+1][s2.length()+1];
        
        int a = 0;

        for (int j=1; j<=s2.length(); j++){
            a+=s2.charAt(j-1);
            dp[0][j] = a;
        }
        
        int b=0;
        for (int i=1; i<= s1.length(); i++){
            b+=s1.charAt(i-1);
            dp[i][0] = b;
        }

        for (int i=1; i<=s1.length(); i++){
            for (int j=1; j<=s2.length(); j++){
                int take = Integer.MAX_VALUE;
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(s1.charAt(i-1)+ dp[i-1][j],
                    s2.charAt(j-1)+ dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
