public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        int p1=-1; int p2=-1;
        int minimum = Integer.MAX_VALUE;

        for (int i=0; i< words.length; i++){
            if (words[i].equals(word1)){
                p1=i;
            }
            if (words[i].equals(word2)){
                p2=i;
            }
            if (p1!=-1 && p2!=-1) minimum = Math.min(minimum, Math.abs(p1-p2));
        }

        return minimum;
    }
}
