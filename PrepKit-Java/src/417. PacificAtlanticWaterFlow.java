class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        int row = heights.length;
        int cols = heights[0].length;
        int[][]grid = new int[row][cols];
        for (int i=0; i< row; i++){
            helper(i,0, grid, heights, 1);
        }
        for (int j=0; j< cols; j++){
            helper(0, j, grid, heights, 1);
        }
        for (int i=0; i< row; i++){
            helper(i,cols-1, grid,heights, 2);
        }
        for (int j=0; j< cols; j++){
            helper(row-1, j, grid, heights, 2);
        }

        return result;
    }

    public void helper(int i, int j, int[][] grid, int[][] matrix, int current){
        if (grid[i][j]==current || grid[i][j]==3) return;
        grid[i][j]+=current;
        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        temp.add(j);
        if (grid[i][j]==3) result.add(temp);

        if (i-1>=0 && matrix[i-1][j]>=matrix[i][j]) helper(i-1, j, grid, matrix, current);
        if(i+1<grid.length && matrix[i+1][j] >= matrix[i][j]) helper(i+1, j, grid, matrix, current);
        if (j-1>=0 && matrix[i][j-1]>=matrix[i][j]) helper(i, j-1, grid,matrix, current);
        if (j+1<grid[0].length && matrix[i][j+1]>=matrix[i][j]) helper(i, j+1, grid, matrix, current);
    }
}
