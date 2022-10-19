class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, 0, dp) - 1;
    }

    public int helper(String s, int i, int[] dp) {

        if (i == s.length()) {
            return 0;
        }

        if (dp[i] != -1)
            return dp[i];

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {

                minCost = Math.min(minCost, 1 + helper(s, j + 1, dp));
            }
        }

        return dp[i] = minCost;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
