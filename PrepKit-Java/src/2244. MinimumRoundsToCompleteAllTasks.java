class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        
        for (int i=0; i< tasks.length; i++){
            hashmap.put(tasks[i], hashmap.getOrDefault(tasks[i],0)+1);
        }
        
        int total=0;
        for (Map.Entry<Integer, Integer> entry: hashmap.entrySet()){
            int curr = entry.getValue();
            if (curr==1) return -1;
            total+=curr/3;
            if (curr % 3 != 0) total+=1;
        }
        return total;
    }
}
