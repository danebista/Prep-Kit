class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for (char c: s.toCharArray()){
            hashmap.put(c, hashmap.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = 
        new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> entry: hashmap.entrySet()){
            pq.offer(entry);
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            for(int i=1; i<= entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();

    }
}