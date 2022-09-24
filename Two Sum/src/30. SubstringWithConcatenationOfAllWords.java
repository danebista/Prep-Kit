import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();

        if (s == null || words.length == 0)
            return result;

        Map<String, Integer> wordMap = new HashMap();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 1) + 1);
        }
        int totalWordLength = words[0].length() * words.length;
        int eachwordLength = words[0].length();

        for (int i = 0; i <= s.length() - totalWordLength; i++) {
            Map<String, Integer> seenMap = new HashMap();
            for (int j = 0; j < words.length; j++) {
                int startIndex = i + j * eachwordLength;
                String set = s.substring(startIndex, startIndex + eachwordLength);

                if (!wordMap.containsKey(set))
                    break;
                seenMap.put(set, seenMap.getOrDefault(set, 1) + 1);

                if (seenMap.get(set) > wordMap.get(set))
                    break;

                if (j + 1 == words.length)
                    result.add(i);
            }
        }

        return result;
    }
}
