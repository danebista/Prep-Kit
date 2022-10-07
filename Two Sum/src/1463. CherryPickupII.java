class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] d : dp) {
            for (int[] ds : d) {
                Arrays.fill(ds, -1);
            }
        }

        return helperPicker(grid, 0, 0, grid[0].length - 1);
    }

    public int helperPicker(int[][] grid, int i, int j1, int j2) {
        int maximum = 0;

        if (j1 < 0 || j1 >= grid[0].length
                || j2 < 0 || j2 >= grid[0].length) {
            return maximum;
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        for (int a1 = -1; a1 <= 1; a1++) {
            for (int b1 = -1; b1 <= 1; b1++) {
                if (j1 == j2) {
                    maximum = Math.max(maximum, grid[i][j1] + helperPicker(grid,
                            i + 1, j1 + a1, j2 + b1));
                } else {
                    maximum = Math.max(maximum, grid[i][j1] + grid[i][j2] +
                            helperPicker(grid, i + 1, j1 + a1, j2 + b1));
                }
            }
        }

        return dp[i][j1][j2] = maximum;
    }
}
