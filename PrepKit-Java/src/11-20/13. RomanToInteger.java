import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hashmap = new HashMap();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && hashmap.get(s.charAt(i)) > hashmap.get(s.charAt(i - 1))) {
                ans += hashmap.get(s.charAt(i)) - 2 * hashmap.get(s.charAt(i - 1));
            } else {
                ans += hashmap.get(s.charAt(i));
            }
        }
        return ans;
    }
}
