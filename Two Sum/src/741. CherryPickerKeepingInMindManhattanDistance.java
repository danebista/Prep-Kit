class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] dps : dp) {
            for (int[] d : dps) {
                Arrays.fill(d, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, helper(grid, 0, 0, 0));
    }

    public int helper(int[][] grid, int i1, int j1, int j2) {
        int m = grid[0].length;
        int i2 = i1 + j1 - j2;// Since i1+j1 = i2+j2;

        if (i2 < 0 || i2 >= grid.length ||
                i1 < 0 || i1 >= grid.length || j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return Integer.MIN_VALUE;

        if (i1 == grid.length - 1 && j1 == grid[0].length - 1) {
            return grid[i1][j1];
        }
        if (grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return Integer.MIN_VALUE;
        if (dp[i1][j1][j2] != Integer.MIN_VALUE)
            return dp[i1][j1][j2];

        int maxi = 0;
        int ans = grid[i1][j1];
        if (j1 != j2)
            ans += grid[i2][j2];
        int curb1 = Math.max(helper(grid, i1, j1 + 1, j2 + 1),
                helper(grid, i1, j1 + 1, j2));
        int curb2 = Math.max(helper(grid, i1 + 1, j1, j2 + 1),
                helper(grid, i1 + 1, j1, j2));
        ans += Math.max(curb1, curb2);

        return dp[i1][j1][j2] = ans;
    }
}
