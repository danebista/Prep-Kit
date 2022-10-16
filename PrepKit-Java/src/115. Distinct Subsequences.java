class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int[] prev = new int[t.length() + 1];
        int[] curr = new int[t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            curr[0] = 1;
            prev[0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }

        return prev[t.length()];
    }
}
