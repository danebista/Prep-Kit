class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int n = grid.length;
        int[][]dp = new int[n][n];

        for (int a[]: dp){
            Arrays.fill(a, Integer.MIN_VALUE);
        }

        for (int i=0; i< grid.length; i++){
            ans = Math.min(ans, recurse(0, i, grid, dp));
        }

        return ans;
    }

    public int recurse(int row, int col, int[][]grid, int[][]dp){
        if (row>=grid.length || row>=grid.length) return Integer.MAX_VALUE;

        if (row==grid.length-1){
            return grid[row][col];
        }

        if (dp[row][col]!=Integer.MIN_VALUE) return dp[row][col];
        int min = Integer.MAX_VALUE;
    
        for (int j=0; j< grid.length; j++){
            if (j == col) continue;
            int temp = grid[row][col]+ recurse(row+1, j, grid, dp);
            min = Math.min(min, temp);
        }

        return dp[row][col] = min;
    }
}