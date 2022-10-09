import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashset = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxSize = 0;

        while (j < s.length()) {
            if (hashset.contains(s.charAt(j))) {
                hashset.remove(s.charAt(i));
                i++;
            } else {
                hashset.add(s.charAt(j));
                if (maxSize < hashset.size()) {
                    maxSize = hashset.size();
                }
                j++;
            }
        }

        return maxSize;
    }
}
