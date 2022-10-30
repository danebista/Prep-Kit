class Solution {
    class Coordinates{
        int x;
        int y;
        int lives;
        Coordinates(int x, int y, int lives){
            this.x = x;
            this.y = y;
            this.lives = lives;
        }
    }
    
    public int shortestPath(int[][] grid, int k) {
         int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
         Queue<Coordinates> queue = new LinkedList();
         queue.offer(new Coordinates(0,0, k));
         int steps=0;
         boolean [][][] visited = new boolean[grid.length+1][grid[0].length+1][k+1];
        
         while (!queue.isEmpty()){
             int size = queue.size();
             for (int i=0; i< size; i++){
                 Coordinates temp = queue.poll();
                 if (temp.x == grid.length-1 && temp.y == grid[0].length-1) return steps;
                
                 visited[temp.x][temp.y][temp.lives] = true;
                 for (int [] dr: dirs){
                     int xcor = dr[0]+temp.x;
                     int ycor = dr[1]+temp.y;
                     int lives = temp.lives;
                     if (lives==-1) continue;
                     if (xcor<0 || xcor>grid.length-1 || ycor<0 || ycor > grid[0].length-1) continue;
                     
                     if (!visited[xcor][ycor][lives] && grid[xcor][ycor]==0){
                         queue.offer(new Coordinates(xcor, ycor, lives));
                         visited[xcor][ycor][lives] = true;
                     }
                     else if (!visited[xcor][ycor][lives] && grid[xcor][ycor]==1 && lives>0){
                         queue.offer(new Coordinates(xcor, ycor, lives-1));
                         visited[xcor][ycor][lives] = true;
                     }
                 }
                 
             }
             steps++;
         }
        
        return -1;
    }
}
