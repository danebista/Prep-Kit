class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList();
        if (words.length == 0)
            return result;

        char[] prevs = words[0].toCharArray();
        Arrays.sort(prevs);
        String prev = new String(prevs);
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            String tempArray = new String(temp);

            if (tempArray.equals(prev))
                continue;
            prev = tempArray;
            result.add(words[i]);
        }

        return result;
    }
}
