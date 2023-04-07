class Solution {
    public int triangularSum(int[] nums) {
        int n= nums.length-1;
        while (true){
            if (n<1) break;
            for (int i=1; i<=n;i++){
                nums[i-1]=nums[i]+nums[i-1];
                nums[i-1]=nums[i-1]%10;
                
            }
            n--;
        }
        return nums[0];
    }
}
