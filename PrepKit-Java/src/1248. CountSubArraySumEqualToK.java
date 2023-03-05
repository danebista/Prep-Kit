class Solution {
    //Convert problem to subarray sum equals to k
    public int numberOfSubarrays(int[] nums, int k) {
        // convert to problem in which we convert it to subarray sums.
        for (int i=0; i< nums.length; i++){
            nums[i]= nums[i]%2;
        }

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        int preSum=0;
        int result=0;
        for (int i=0; i< nums.length; i++){
            preSum+=nums[i];
            if (hashmap.containsKey(preSum-k)){
                result+=hashmap.get(preSum-k);
            }
            hashmap.put(preSum, hashmap.getOrDefault(preSum, 0)+1);
        }
        return result;
    }
}
