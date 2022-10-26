class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        hashmap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashmap.containsKey(sum % k)) {
                if (i - hashmap.get(sum % k) >= 2)
                    return true;
            } else {
                hashmap.put(sum % k, i);
            }
        }

        return false;
    }
}
