public class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] preSum = new long[nums.length];
        int[] ans = new int[nums.length];
        for (int i=0; i< nums.length; i++){
            if (i==0)preSum[i]=nums[0];
            else preSum[i] = preSum[i-1]+nums[i];
        }
        for (int i=0; i< nums.length; i++){
            if (i<k) {
                ans[i] = -1;
            }
            else if (i+k>=nums.length){
                ans[i]=-1;
            }
            else{
                int leftIndex = i-k-1;
                long leftValue = leftIndex>=0?preSum[leftIndex]:0;
                int rightIndex=i+k;
                
                long total =  preSum[rightIndex]-leftValue;
                ans[i] = (int)(total/(2*k+1));
            }
        }
        return ans;
     
    }
}
 {
    
}
