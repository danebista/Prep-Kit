class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0;
        int mask =nums[0];
        int length = 1;
        for (int i=1; i< nums.length; i++){
            while (l<i && (nums[i] & mask)!=0){
                mask = mask^ nums[l];
                l++;
            
            }

            if ((mask & nums[i])==0){
                length = Math.max(length, i-l+1);
                mask = mask|nums[i];
            }
        }

        return length;
    }
}
