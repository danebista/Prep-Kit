class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (k>nums.length) return 0;
        HashMap<Integer, Integer> hashmap= new HashMap<>();
        long max=0;
        long sum =0;
      
        for (int i=0; i< k; i++){
           hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
           sum +=nums[i];
        }
        if (hashmap.size()==k) max = Math.max(max, sum);
        
        for (int i=k; i<nums.length; i++){
            sum-=nums[i-k];
            hashmap.put(nums[i-k],hashmap.get(nums[i-k])-1);
            if (hashmap.get(nums[i-k])==0) hashmap.remove(nums[i-k]);
           
            sum+=nums[i];
           
            if (!hashmap.containsKey(nums[i])) {
               
                if (hashmap.size()==k-1){
                    max = Math.max(max, sum);
                }
               
            }
            
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
        }

        return max;
    }
}
