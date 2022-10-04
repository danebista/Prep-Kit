class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int left = 0;
                int right = 0;
                int min = Integer.MAX_VALUE;

                if (i - 1 >= 0) {

                    min = Math.min(grid[i - 1][j], min);
                }
                if (j - 1 >= 0) {
                    min = Math.min(grid[i][j - 1], min);
                }
                if (min != Integer.MAX_VALUE) {
                    grid[i][j] += min;
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
