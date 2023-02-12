class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        int l=0;
        int r=nums.length-1;
        long ans=0;
        while (l<r){
            long num =Long.parseLong(String.valueOf(nums[l])+String.valueOf(nums[r]));
            ans+=num;
            l++;
            r--;
        }
        if (nums.length%2!=0) ans+=nums[l];
        return ans;
    }
}
