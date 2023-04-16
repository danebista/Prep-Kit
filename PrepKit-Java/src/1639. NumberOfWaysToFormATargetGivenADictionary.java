class Solution {
    public int numWays(String[] words, String target) {
        int[][] indexFinder = new int[words[0].length()][26]; 
        long[][]dp = new long[words[0].length()][target.length()];
        
        for (long[]d:dp){
            Arrays.fill(d, -1);
        }

        for (int i=0; i< words.length; i++){
            String word = words[i];
            for (int j=0; j< word.length(); j++){
                indexFinder[j][word.charAt(j)-'a']++;
            }
        }
        int mod = (int)1e9+7;
        return (int)helper(indexFinder, 0, 0, target, dp)%mod;
    }

    public long helper(int[][] indexFinder, int i, int j, String target, long[][]dp){
        long mod = (long)1e9+7;

        if (i>=indexFinder.length){
           if (j>=target.length()) return 1;

           return 0;
        }
     
        if (j>=target.length()) return 1;
        if (dp[i][j]!=-1) return dp[i][j];

        long val=0;
        if (indexFinder[i][target.charAt(j)-'a']>0){
            val= (indexFinder[i][target.charAt(j)-'a'] * (helper(indexFinder, i+1, j+1, target, dp)%mod))%mod;
        }
        val += helper(indexFinder, i+1, j, target, dp)%mod;

        return dp[i][j]=val%mod;
    }
}
