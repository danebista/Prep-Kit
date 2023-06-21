class Solution {
    public long fun(int[] nums,int[] cost,int n,int k){
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += Math.abs(k-nums[i])*(long)(cost[i]);
        }
        return ans;
    }
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int l = nums[0],r = nums[0];
        for(int i=0;i<n;i++){
            l = Math.min(l,nums[i]);
            r = Math.max(r,nums[i]);
        }
        long ans = Long.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            long val1 = fun(nums, cost, n, mid-1);
            long t1 = fun(nums,cost,n,mid);
            long t2 = fun(nums,cost,n,mid+1);
            if(val1 <t2){
                r = mid-1;
            }else{
                l = mid+1;
            }
            ans = Math.min(ans, t1);
        }
        return ans;
    }
}
