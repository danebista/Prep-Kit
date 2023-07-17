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

class Solution {
     
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        int max = Integer.MIN_VALUE;
        if(k == 1){
            for(int i = 0; i < events.length; i++){
                max = Math.max(max, events[i][2]);
            }
            return max;
        }
        
        int[][] dp = new int[events.length][k+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return maxValue(events, k, 0, dp);
    }
    
    private int maxValue(int[][] events, int k, int start, int[][] dp){
        
        if(start >= events.length){
            return 0;
        }
        if(k == 1){
            // if there was only one event we would go ahead and just attend it
            return events[start][2];
        }
        
        if(dp[start][k] != -1){
            return dp[start][k];
        }
        
        int max = events[start][2];
        
        for(int i = start + 1; i < events.length; i++){
            int result = 0;
            max = Math.max(events[i][2], max);
            if(events[start][1] < events[i][0]){
                result = events[start][2] + maxValue(events, k-1, i, dp);
            }
            
            max = Math.max(result, max);
        }
        
        // Skip the current iteration
        int skip = maxValue(events, k, start+1, dp);
        
        max = Math.max(max, skip);
        
        return dp[start][k] = max;
    }
}
