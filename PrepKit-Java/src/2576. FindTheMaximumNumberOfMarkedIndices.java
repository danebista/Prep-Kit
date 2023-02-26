class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int st=0;
        int mid=(n+1)/2;
        while(mid<n){
            if(nums[st]*2<=nums[mid]) st++;
            mid++;
        }
        return st*2;
    }
}

