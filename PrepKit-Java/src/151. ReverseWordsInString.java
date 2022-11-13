class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        String newString = s.trim();

        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == ' ') {
                ans.insert(0, " " + word.toString());
                word.setLength(0);
                while (newString.charAt(i) == ' ')
                    i++;
                i--;
            } else {
                word.append(newString.charAt(i));
            }
        }
        String answer = word.toString() + ans.toString();
        return answer;
    }
}
