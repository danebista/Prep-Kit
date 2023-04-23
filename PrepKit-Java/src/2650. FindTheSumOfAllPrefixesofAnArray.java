class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[]converter = new long[nums.length];
        int max = 0;
        for(int i=0; i< nums.length; i++){
            max = Math.max(max, nums[i]);
            if (i==0){
                converter[i]= nums[i]+nums[i];
            }
            else{
                converter[i]= converter[i-1]+nums[i]+max;
            }
        }

        return converter;
    }
}
