class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        
        for (int num: nums){
            hashmap.put(num, hashmap.getOrDefault(num, 0)+1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();

        while(!hashmap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            List<Integer> erase = new ArrayList<>();

            for (Map.Entry<Integer, Integer> val: hashmap.entrySet()){
                int f = val.getKey();
                int s = val.getValue();

                temp.add(f);
                s--;

                if (s==0) erase.add(f);

                hashmap.put(f, s);
            }

            ans.add(temp);
            for (int i: erase){
                hashmap.remove(i);
            }
        }

        return ans; 
    }
}
