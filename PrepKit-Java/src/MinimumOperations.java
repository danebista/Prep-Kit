public class MinimumOperations {
    

class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int[] dp =new int[n+1];
        dp[0]=0;
        for (int i=1; i<= n; i++){
            int take = Integer.MAX_VALUE;
            if (i %2==0){
               take = 1 + dp[i/2];
            }
            int notTake = 1 + dp[i-1];
            dp[i]=Math.min(take, notTake);
        }
        
        return dp[n];
        
    }
    
}
}
