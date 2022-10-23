class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s, int index, int[] dp) {

        if (index >= s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0')
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int res = helper(s, index + 1, dp);

        if (index + 1 <= s.length() - 1 && (s.charAt(index) == '1' ||
                (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
            res += helper(s, index + 2, dp);
        }

        return dp[index] = res;
    }

}

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == '0') {
                dp[index] = 0;
                continue;
            }
            int res = dp[index + 1];

            if (index + 1 <= s.length() - 1 && (s.charAt(index) == '1' ||
                    (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
                res += dp[index + 2];
            }
            dp[index] = res;
        }

        return dp[0];
    }

}
