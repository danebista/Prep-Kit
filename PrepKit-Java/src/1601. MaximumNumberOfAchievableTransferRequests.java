class Solution {
    int ans =0 ;
     public int maximumRequests(int n, int[][] requests) {
         int[] in = new int[25];
         int[] out = new int[25];
         for( int[] it : requests)
         {
             out[it[1]]++;
             in[it[0]]++;
         }
         int flag = 0;
         for( int i = 0 ; i <n ; i++)
         {
             if(in[i]!=out[i])
                 flag=1;
         }
         if(flag==0)
             return requests.length;
         int[] cnt = new int[n];
         backtrack(cnt,0,n,0,requests);
         return ans;
 
     }
     public void backtrack ( int[] cnt , int step ,int n,int cur,int[][] req)
     {
         int flag =0 ;
         for( int i = 0 ; i< n ; i++)
         {
             if(cnt[i]!=0)
             {
                 flag=1;
                 break;
             }
         }
         if(flag==0 )
         {
             ans = Math.max(ans, cur);
         }
         if(step == req.length )
             return ;
         for( int i = step ; i< req.length ; i++)
         {
             cnt[ req[i][1] ]++;
             cnt[ req[i][0] ]-- ;
             backtrack(cnt,i+1,n,cur+1,req);
             cnt[req[i][1]]--;
             cnt[req[i][0]]++;
         }
 
     }
 }
 