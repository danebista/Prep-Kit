public class PrintWordsVertically {
    class Solution {
        public List<String> printVertically(String s) {
            List<String> result = new ArrayList();
            String[] wordArray = s.trim().split(" ");
            System.out.println(Arrays.toString(wordArray));
            int max = 0;
            for (String word : wordArray) {
                max = Math.max(max, word.length());
            }
            int index = 0;
            for (int i = 0; i < max; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < wordArray.length; k++) {
                    if (index < wordArray[k].length()) {
                        sb.append(wordArray[k].charAt(index));
                    } else {
                        sb.append(" ");
                    }
                }
                index++;
                while (sb.charAt(sb.length() - 1) == ' ') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                result.add(sb.toString());
            }

            return result;
        }
    }
}
