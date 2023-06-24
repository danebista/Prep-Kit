class Solution {
    public int tallestBillboard(int[] rods) {
        return helper(rods, 0,0, 0);
    }

    public int helper(int[]rods, int index, int r1, int r2){
        if (index==rods.length){
            if (r1==r2){
                return r1;
            }
            return Integer.MIN_VALUE;
        }
        int val1 = helper(rods, index+1, r1+rods[index], r2);
        int val2 = helper(rods, index+1, r1, r2+rods[index]);
        int val3 = helper(rods, index+1, r1, r2);

        return Math.max(val1,Math.max(val2, val3));
    }
}

class Solution {
    
    public int tallestBillboard(int[] rods) {
        int[][]dp= new int[rods.length][10001];
        for (int[]d:dp){
            Arrays.fill(d, -1);
        }
        return helper(rods, 0,0, dp);
    }

    public int helper(int[]rods, int index, int val1, int[][] dp){
        if (index==rods.length){
            if (val1==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if (dp[index][val1+5000]!=-1) return dp[index][val1+5000];
        int d1 =rods[index]+ helper(rods, index+1, val1+rods[index], dp);
        int val2 = helper(rods, index+1, val1-rods[index],dp);
        int val3 = helper(rods, index+1, val1, dp);

        return dp[index][val1+5000]=Math.max(d1,Math.max(val2, val3));
    }
}