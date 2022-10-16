class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d)
            return -1;
        int[][] dp = new int[jobDifficulty.length + 1][d + 1];
        for (int[] dy : dp) {
            Arrays.fill(dy, -1);
        }
        return helper(0, d, jobDifficulty, dp);
    }

    public int helper(int index, int d, int[] job, int[][] dp) {

        if (d == 1) {
            int maxi = Integer.MIN_VALUE;

            for (int i = index; i < job.length; i++) {
                maxi = Math.max(maxi, job[i]);
            }

            return maxi;
        }
        if (dp[index][d] != -1)
            return dp[index][d];

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = index; i <= job.length - d; i++) {
            maxValue = Math.max(maxValue, job[i]);
            minValue = Math.min(minValue, maxValue + helper(i + 1, d - 1, job, dp));
        }
        return dp[index][d] = minValue;
    }
}
