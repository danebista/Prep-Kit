class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        int prefix=0;
        long count=0;
        
        for (int i=0; i< nums.length; i++){
            prefix=prefix^nums[i];
            if (hashmap.containsKey(prefix)){
                count+=hashmap.get(prefix);
            }
            
            hashmap.put(prefix, hashmap.getOrDefault(prefix,0)+1);
            
        }
        
        return count;
    }
}
