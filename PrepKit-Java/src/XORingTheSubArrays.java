public class Solution {
    public int solve(int[] A) {
        //no of i in a subarray =(i+1) *(n-i)
        
        int ans = 0;
        if (A.length % 2 ==0) return 0;
        else{
            for (int i=0; i< A.length; i+=2){
                ans = ans ^ A[i];
            }
            return ans;
        }
        
    }
}
