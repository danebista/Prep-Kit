class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][]visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Pair(0,0));
        visited[0][0]=true;
        int m = grid.length;
        int n = grid[0].length;
        int steps = 1;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int k=0; k< size; k++){
                Pair curr = queue.poll();
                
                int i= curr.x;
                int j = curr.y;
                System.out.print(grid[i][j]);
                if (i+1>=0 && i+1<m && j+2>=0 && j+2<n && !visited[i+1][j+2] && steps==grid[i+1][j+2]){
                    queue.offer(new Pair(i+1, j+2));
                    visited[i+1][j+2]=true;
                }
                if (i+1>=0 && i+1<m && j-2>=0 && j-2<n && !visited[i+1][j-2] && steps==grid[i+1][j-2]){
                    queue.offer(new Pair(i+1, j-2));
                    visited[i+1][j-2]=true;
                }
                
                if (i-1>=0 && i-1<m && j-2>=0 && j-2<n && !visited[i-1][j-2] && steps==grid[i-1][j-2]){
                    queue.offer(new Pair(i-1, j-2));
                    visited[i-1][j-2]=true;
                }
                
                if (i-1>=0 && i-1<m && j+2>=0 && j+2<n && !visited[i-1][j+2] && steps==grid[i-1][j+2]){
                    queue.offer(new Pair(i-1, j+2));
                    visited[i-1][j+2]=true;
                }
               
                if (j+1>=0 && j+1<n && i+2>=0 && i+2<m && !visited[i+2][j+1] && steps==grid[i+2][j+1]){
                    queue.offer(new Pair(i+2, j+1));
                    visited[i+2][j+1]=true;
                }
                if (j+1>=0 && j+1<n && i-2>=0 && i-2<m && !visited[i-2][j+1] && steps==grid[i-2][j+1]){
                    queue.offer(new Pair(i-2, j+1));
                    visited[i-2][j+1]=true;
                }
                
                if (j-1>=0 && j-1<n && i-2>=0 && i-2<m && !visited[i-2][j-1] && steps==grid[i-2][j-1]){
                    queue.offer(new Pair(i-2, j-1));
                    visited[i-2][j-1]=true;
                }
                
                if (j-1>=0 && j-1<n  && i+2>=0 && i+2<m && !visited[i+2][j-1] && steps==grid[i+2][j-1]){
                    queue.offer(new Pair(i+2, j-1));
                    visited[i+2][j-1]=true;
                }
               
            }
            steps++;
        }
        
        for (int i=0; i< visited.length; i++){
            for (int j=0; j< visited[0].length; j++){
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }
    
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x =x;
            this.y=y;
        }
    }
}
