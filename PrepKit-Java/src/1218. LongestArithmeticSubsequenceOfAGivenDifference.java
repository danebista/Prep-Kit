class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int max=0;
        for (int i=0; i< arr.length; i++){
            if (!hashmap.containsKey(arr[i]-difference)){
                hashmap.put(arr[i], 1);
            }
            else {
                 hashmap.put(arr[i], hashmap.get(arr[i]-difference)+1);
            }

            max = Math.max(max, hashmap.get(arr[i]));
        }

        return  max;
    }
}
