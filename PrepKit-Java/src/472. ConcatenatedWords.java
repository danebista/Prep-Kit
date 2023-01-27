class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> hashset = new HashSet<>();
        for (int i=0; i< words.length; i++){
            hashset.add(words[i]);
        }
        HashMap<String, Boolean> cache = new HashMap<>();

        List<String> result = new ArrayList<>();
        for (String word: words){
            if (helper(word, hashset, cache)) result.add(word);
        }

        return result;
    }

    public boolean helper(String word, HashSet<String> hashset, HashMap<String, Boolean> cache){
        if (cache.containsKey(word)) return cache.get(word);
        // no need of base case becasue hashset.contains handles that inside loop;
        for (int i=1; i< word.length(); i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (hashset.contains(prefix) && (hashset.contains(suffix)
            || helper(suffix, hashset,cache))) {
                cache.put(word, true);
                return true;
            }
        }
        cache.put(word, false);
        return false;
    }
}