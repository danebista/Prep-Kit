class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        
        int[][] arr = new int[n][2];
        int[][] dp = new int[n][n+1];
        for (int[] d: dp){
            Arrays.fill(d, -1);
        }

        for(int i=0;i<n;i++){
            arr[i][0]=scores[i];
            arr[i][1]=ages[i];
        }

        Arrays.sort(arr, (a,b)-> a[1]==b[1]? a[0]-b[0]: a[1]-b[1]);
        return dfs(arr,0,-1, dp);
        
    }

    int dfs(int[][] arr,int idx,int pre, int[][]dp){
       
        if(idx==arr.length)return 0;
        if (dp[idx][pre+1]!=-1) return dp[idx][pre+1];
        int ans=0;
        //use 
        int a = Integer.MIN_VALUE;
        if( pre==-1 || arr[idx][0]>=arr[pre][0]){
            a= dfs(arr,idx+1,idx, dp)+arr[idx][0];
          
        } 
        //not use
        int b = dfs(arr,idx+1,pre, dp);
    
        return dp[idx][pre+1]=Math.max(a,b);

    }
}
