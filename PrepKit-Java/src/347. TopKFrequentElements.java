class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            bucket.get(value).add(key);
        }
        int[] result = new int[k];
        int m = 0;
        while (m < k) {
            for (int i = bucket.size() - 1; i >= 0; i--) {
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    result[m] = bucket.get(i).get(j);
                    m += 1;
                    if (m == k)
                        return result;
                }
            }
        }
        return result;
    }
}
