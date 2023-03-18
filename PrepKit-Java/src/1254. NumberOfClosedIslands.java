class Solution {
    public int closedIsland(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(dfs(i,j,grid)){
                        res++;
                        System.out.println(i+" "+j);
                    }
                }
            }
        }
        return res;
    }
    public boolean dfs(int i,int j,int[][] grid){
        grid[i][j]=1;
        boolean res = true;
        if (i+1==grid.length || i-1==-1 || j+1==grid[0].length || j-1==-1){
            res=false;
        }
        if(i+1< grid.length && grid[i+1][j]==0){
            res &= dfs(i+1, j, grid);
        }
        if(i-1>=0 && grid[i-1][j]==0){
           res &= dfs(i-1, j, grid);
        }
        if(j+1<grid[0].length && grid[i][j+1]==0){
            res &= dfs(i, j+1, grid);
        }
        if(j-1>=0 && grid[i][j-1]==0){
           res &= dfs(i, j-1, grid);
        }
        return res;
    }
}
// if I return at the first boundary i Encounter, i MISS SOME VALUES
 