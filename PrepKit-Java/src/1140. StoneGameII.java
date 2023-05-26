class Solution {
    int[] preSum;
    int n;
    int[][][]cache;
    public int stoneGameII(int[] piles) {
        preSum = new int[piles.length+1];
        n = piles.length;
        cache = new int[n][n+1][2];
        for (int i=0; i<piles.length; i++){
            preSum[i+1] = preSum[i]+piles[i];
        }

        return helper(preSum, 1,1,0);
    }
  
    public int helper(int[] preSum, int M, int alice, int index){
        if (index>=n) return 0;
        if (cache[index][M][alice]!=0) return cache[index][M][alice];
        int sum=0;

        for (int x=1; x<=2*M && (index+x <=n); x++){
            int pSum = preSum[index+x]-preSum[index];
            int recSum = helper(preSum, Math.max(x,M), ((alice==1)?0:1), index+x);
            if (alice==1){
                if (sum==0) sum = Integer.MIN_VALUE;
                sum = Math.max(sum, recSum+pSum);
            }else{
                if (sum==0) sum= Integer.MAX_VALUE;
                sum = Math.min(sum, recSum);
            }
        }
        return cache[index][M][alice]= sum;
    }
}
