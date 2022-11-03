class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> hashmap = new HashMap();
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i].charAt(1) + "" + words[i].charAt(0);
            if (hashmap.containsKey(temp)) {
                result += 4;
                hashmap.put(temp, hashmap.get(temp) - 1);
                if (hashmap.get(temp) == 0)
                    hashmap.remove(temp);
                continue;
            }
            hashmap.put(words[i], hashmap.getOrDefault(words[i], 0) + 1);
        }

        for (String k : hashmap.keySet()) {
            if (hashmap.get(k) == 1 && (k.charAt(1) + "" + k.charAt(0)).equals(k)) {
                result += 2;
                break;
            }
        }

        return result;
    }
}
