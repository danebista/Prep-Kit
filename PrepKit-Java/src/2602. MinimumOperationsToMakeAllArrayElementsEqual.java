class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        
        List<Long> list = new ArrayList<>();
        
        Arrays.sort(nums);
        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        
        arr1[0] = nums[0];
        for(int i=1; i<n; i++){
            arr1[i] = arr1[i-1]+nums[i];
        }
        
        arr2[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            arr2[i] = arr2[i+1]+nums[i];
        }
        
        for(int i : queries){
            long sum = 0l;
            int s=0; int e = n-1;
            
            while(s<=e){
                int mid = s + (e-s)/2;
                
                if(nums[mid] <= i){ s = mid+1; }
                else{ e = mid-1; }
            }
            
            sum += s>0 ?((long)i * (long)s) - arr1[s-1] :0;
            
            sum += s<n ?arr2[s] - ((long)(n-s) * (long)i) :0;
            
            list.add(sum);
        }
        
        return list;
        
    }
}