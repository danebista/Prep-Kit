class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0]=scores[i];
            arr[i][1]=ages[i];
        }

        Arrays.sort(arr, (a,b)-> a[1]==b[1]? a[0]-b[0]: a[1]-b[1]);
        int[]dp = new int[n+1];
        int max=0;
        for(int i=0;i<n;i++){
            dp[i]=arr[i][0];
            for(int j=i-1;j>=0;j--){
              if(arr[j][0]<=arr[i][0]) dp[i]=Math.max(dp[i],dp[j]+arr[i][0]);
            }
            max=Math.max(dp[i],max);
        }

        return max;
       
	   //here we can also uing DFS+Memory
        // Map<Pair<Integer,Integer>,Integer> memo= new HashMap<>();
        // int max=0;
        // for(int i=0;i<n;i++){
        //     max=Math.max(max,dfs(arr,i,0,memo));    
        // }
        
    }

    int dfs(int[][] arr,int idx,int pre){
       
        if(idx==arr.length)return 0;
    
        int ans=0;
        //use 
        int a = Integer.MIN_VALUE;
        if(arr[idx][0]>=pre){
            a= dfs(arr,idx+1,arr[idx][0])+arr[idx][0];
          
        } 
        //not use
        int b = dfs(arr,idx+1,pre);
    
        return Math.max(a,b);

    }
}
