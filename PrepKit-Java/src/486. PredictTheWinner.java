class Solution {
    int[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        dp = new int[20][20];

        for (int value : nums) {
            sum += value;
        }
        int playerScore = gameTheory(nums, l, r);

        return playerScore >= sum - playerScore;
    }

    public int gameTheory(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != 0)
            return dp[i][j];

        dp[i][j] = Math.max(nums[i] + Math.min(
                gameTheory(nums, i + 2, j), gameTheory(nums, i + 1, j - 1)),
                nums[j] + Math.min(gameTheory(nums, i + 1, j - 1), gameTheory(
                        nums, i, j - 2)));

        return dp[i][j];
    }
}
