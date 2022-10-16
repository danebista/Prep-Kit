class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = findLCS(word1, word2);
        int deleteOperations = word1.length() - lcs + word2.length() - lcs;

        return deleteOperations;
    }

    public int findLCS(String word1, String word2) {
        int[] prev = new int[word2.length() + 1];
        int[] curr = new int[word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[word2.length()];
    }
}
