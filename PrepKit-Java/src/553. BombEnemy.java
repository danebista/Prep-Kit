public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int max_counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    max_counter = Math.max(max_counter, findCount(grid, i, j));
                }
            }
        }

        return max_counter;
    }

    public int findCount(char[][] grid, int x_pos, int y_pos) {
        int counter = 0;
        for (int i = x_pos; i >= 0; i--) {
            if (grid[i][y_pos] == 'E')
                counter++;
            if (grid[i][y_pos] == 'W')
                break;
        }

        for (int i = x_pos + 1; i < grid.length; i++) {
            if (grid[i][y_pos] == 'E')
                counter++;
            if (grid[i][y_pos] == 'W')
                break;
        }

        for (int i = y_pos; i >= 0; i--) {
            if (grid[x_pos][i] == 'E')
                counter++;
            if (grid[x_pos][i] == 'W')
                break;
        }

        for (int i = y_pos + 1; i < grid[0].length; i++) {
            if (grid[x_pos][i] == 'E')
                counter++;
            if (grid[x_pos][i] == 'W')
                break;
        }

        return counter;
    }
}
