class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r= sb.toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i=1; i<=s.length(); i++){
            for (int j=1; j<=s.length(); j++){
                if (s.charAt(i-1)==r.charAt(j-1)) {
                    dp[i][j]= 1+ dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}

