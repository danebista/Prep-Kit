public class Solution {
    int dp[];
    HashSet<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        dp=new int[n];
        Arrays.fill(dp,-1);
        
        set=new HashSet<>();
        for(String str:dictionary){
            set.add(str);

        }
        return helper(0,n,s);

    }
    int helper(int ind,int n,String s){
        if(ind==n)
        return 0;

        if(dp[ind]!=-1)
        return dp[ind];

        int ans=1+helper(ind+1,n,s);

        for(int i=ind;i<n;i++){
            String str=s.substring(ind,i+1);
            if(set.contains(str))
            {
                ans=Math.min(ans,helper(i+1,n,s));
            }

        }

        return dp[ind]=ans;

    }

    
}
 {
    
}
