class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int maxlen = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!compare(words[j], words[i]))
                    continue;
                if (dp[j] + 1 <= dp[i])
                    continue;
                dp[i] = 1 + dp[j];
                maxlen = Math.max(maxlen, dp[i]);
            }
        }

        return maxlen;

    }

    public boolean compare(String s1, String s2) {
        boolean oneDiff = true;

        if (s2.length() - s1.length() != 1)
            return false;
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (i < s1.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s1.length() && j == s2.length();
    }
}
