public class UniqueNumberOfOccurences {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            HashSet<Integer> hashset;

            for (int i = 0; i < arr.length; i++) {
                hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
            }

            hashset = new HashSet<>(hashmap.values());

            return hashmap.size() == hashset.size();
        }
    }
}
