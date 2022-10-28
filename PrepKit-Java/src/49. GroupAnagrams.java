class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap();

        for (int i = 0; i < strs.length; i++) {

            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String orderedStr = new String(tempArray);

            if (hashmap.containsKey(orderedStr)) {
                List<String> temp = hashmap.get(orderedStr);
                temp.add(strs[i]);

                hashmap.put(orderedStr, temp);
            } else {
                List<String> temp = new ArrayList();
                temp.add(strs[i]);
                hashmap.put(orderedStr, temp);
            }
        }

        List<List<String>> result = new ArrayList();

        for (List<String> value : hashmap.values()) {
            result.add(value);
        }

        return result;
    }
}
