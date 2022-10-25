class Solution {
    public int nthUglyNumber(int n) {
        int multi2= 0;
        int multi3 = 0;
        int multi5 = 0;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i=1; i<n; i++){
           int twoAns = dp[multi2] * 2;
           int threeAns = dp[multi3] * 3;
           int fiveAns = dp[multi5] * 5;
           int minNo = Math.min(twoAns, Math.min(threeAns, fiveAns));
           dp[i] = minNo;
           if (minNo == twoAns) multi2++;
           if (minNo == threeAns) multi3++;
           if (minNo == fiveAns) multi5++;
        }
        return dp[n-1];       
    }
}

    
}
