public class Solution {
    /**
     * @param words: the words
     * @param s:     the string
     * @return: the string with least number of tags
     */
    public String boldWords(String[] words, String s) {
        // Write your code here
        boolean[] validCharacter = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {

                    for (int k = i; k < (i + word.length()); k++) {

                        validCharacter[k] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString((validCharacter)));
        int index = 0;
        int start = 0;
        StringBuilder result = new StringBuilder();
        while (index < s.length()) {
            if (!validCharacter[index]) {
                result.append(s.charAt(index));
                start += 1;
                index++;
            } else {
                result.append("<b>");
                while (index < s.length() && validCharacter[index]) {
                    index++;
                }
                result.append(s.substring(start, index));
                result.append("</b>");
                start = index;
            }
        }

        return result.toString();
    }
}
