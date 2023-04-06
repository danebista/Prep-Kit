class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        int maxVal = 0;
        for (int i=nums.size()-1; i>=0; i--){
            for (int j= nums.get(i).size()-1; j>=0; j--){
                int key = i+j;
                maxVal = Math.max(maxVal, key);

                if (!hashmap.containsKey(key)){
                    hashmap.put(key, new ArrayList<>());
                }

                hashmap.get(key).add(nums.get(i).get(j));
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<=maxVal; i++){
            if (!hashmap.containsKey(i)) continue;
            List<Integer> values = hashmap.get(i);
            for (Integer val: values){
                result.add(val);
            }
        }

        int[] results = new int[result.size()];
        int j=0;
        for (int i=0; i< result.size(); i++){
            results[j++]= result.get(i);
        }

        return results;
    }
}
