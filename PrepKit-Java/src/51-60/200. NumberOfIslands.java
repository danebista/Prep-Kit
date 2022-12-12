class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += helper(grid, i, j);
            }
        }
        return res;
    }

    public int helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);

        return 1;
    }
}
