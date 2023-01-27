class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        if (word1.length()!=word2.length()) return false;
        for (int i=0; i<word1.length(); i++){
            word1Count[word1.charAt(i)-'a']++;
            word2Count[word2.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++){
            if ((word1Count[i]!=0 && word2Count[i]==0)
                || (word2Count[i]!=0 && word1Count[i]==0)) return false;
        }

        //if some character is present in one and that character is not present in second
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i=0; i<26; i++){
            if (word1Count[i]!=0){

                hashmap.put(word1Count[i], hashmap.getOrDefault(word1Count[i],0)+1);
            }
            if (word2Count[i]!=0){
                hashmap.put(word2Count[i], hashmap.getOrDefault(word2Count[i],0)-1);
            }
        }

        for (Integer value: hashmap.values()){
            if (value!=0) return false;
        }
        return true;

        // abc bca 1-3, 1->2 1->1 1->0
        // remember the technique of frequency mapping.
    }
}