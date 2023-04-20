class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        while (i< word1.length() && j< word2.length()){
            if (flag){
                sb.append(word1.charAt(i++));
                flag = false;
            }
            else {
                sb.append(word2.charAt(j++));
                flag = true;
            }
        }

        while (i < word1.length()){
            sb.append(word1.charAt(i++));
        }
        while (j< word2.length()){
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
