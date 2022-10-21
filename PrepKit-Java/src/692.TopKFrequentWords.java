class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         HashMap<String, Integer> wordCounts = new HashMap<>();
        for(String word : words) wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> 
            wordCounts.get(s1)==wordCounts.get(s2)
            ? s2.compareTo(s1):wordCounts.get(s1) - wordCounts.get(s2));
        
      
        for(String word : wordCounts.keySet()) {
            minHeap.offer(word);
            
            if(minHeap.size() > k) minHeap.poll(); 
        }
        
        LinkedList<String> toReturn = new LinkedList<>();
        while(!minHeap.isEmpty()) toReturn.addFirst(minHeap.poll());
        
        return toReturn;
    }
}