public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for (int i=31; i>=0; i--){
            int c =0;
            for (int j=0; j< A.length; j++){
                if ((A[j] & 1<<i) !=0){
                    c++;
                }
            }
            if (c%3!=0) ans+=(1<<i);
        }
        
        return ans;
    }
}
