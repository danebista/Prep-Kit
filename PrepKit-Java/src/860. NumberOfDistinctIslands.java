public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    // Store same patterns
    public int numberofDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j, "start#");
                    set.add(sb.toString());
                }
            }
        }
        Iterator itr = set.iterator();

        // check element is present or not. if not loop will
        // break.
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return set.size();
    }

    public void dfs(int[][] grid, StringBuilder sb, int i, int j, String dir) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return;
        }
        // mark as visited
        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid, sb, i + 1, j, "d");
        dfs(grid, sb, i, j + 1, "r");
        dfs(grid, sb, i - 1, j, "u");
        dfs(grid, sb, i, j - 1, "l");
        sb.append("#end");
    }
}
