class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int max = 0;
            for (int j = left; j <= right; j++) {

                max = Math.max(max, j + nums[j]);
            }
            left = right + 1;
            right = max;
            jumps += 1;
        }

        return jumps;
    }
}

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int count=0;
        hashmap.put(0,1);
        int runningSum=0;
        
        for (int i=0; i< nums.length; i++){
            runningSum+=nums[i];
            int remains = runningSum % k;
            
            if (remains<0){
                remains+=k;
            }

            if (hashmap.containsKey(remains)){
                count += hashmap.get(remains);
            }

            hashmap.put(remains, hashmap.getOrDefault(remains, 0) + 1);
        }

        return count;
    }
}