public class SubArrayWithGivenXOR {
    public class Solution {
        public int solve(int[] A, int B) {
            int pref = 0;
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            hashmap.put(0,1);
            int count=0;
            for (int i=0; i< A.length; i++){
                pref = pref ^ A[i];
                int target= pref ^ B;
                if (hashmap.containsKey(target)) count+=hashmap.get(target);
                if (hashmap.containsKey(pref)) hashmap.put(pref, hashmap.get(pref)+1);
                else hashmap.put(pref, 1);
            }
            return count;
            
        }
    }
}
