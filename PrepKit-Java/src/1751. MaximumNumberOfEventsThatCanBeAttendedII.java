class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b)->(a[0]==b[0]?a[1]-b[1]: a[0]-b[0]));
        
        int max = 0;
        for (int[] event: events){
            max = Math.max(max, event[1]);
        }
        int[][][] dp = new int[k+1][events.length][max+2];
        for (int [][]ds:dp){
            for (int[]d: ds){
                Arrays.fill(d,-1);
            }
        }

        return helper(events, k, 0,-1, dp);
    }

    public int helper(int[][]events, int k, int index, int prev, int[][][]dp){
        if (index>=events.length || k==0){
            return 0;
        }
        System.out.println(k+"-"+index+"-"+prev);
        if (dp[k][index][prev+1]!=-1)return dp[k][index][prev+1];

        int notTake = helper(events,k, index+1, prev, dp);
        int take = Integer.MIN_VALUE;
        if (prev==-1 || events[index][0]>prev){
            take = events[index][2]+ helper(events, k-1, index+1, events[index][1], dp);
        }
        
        return dp[k][index][prev+1] = Math.max(take, notTake);
        
    }
}
