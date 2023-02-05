
class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        //if at any iteration of the bfs, there is only one path
        //then all cells must pass through that path. Hence, solution reached.//
        Pair newPair = new Pair(0,0);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(newPair);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0]= true;

        while(!queue.isEmpty()){
            if(queue.size()==1){
                if(!((queue.peek().x==0 && queue.peek().y==0) || (queue.peek().x==m-1 &&
                queue.peek().y==n-1))){
                    return true;
                }
            }
            if (queue.size()==1 && (queue.peek().x==m-1 &&
                queue.peek().y==n-1)) return false;

            int size = queue.size();

            for (int i=0; i< size; i++){
                Pair curr = queue.poll();
                //if (curr.x==m-1 && curr.y==n-1) return false;
                
                if (curr.x+1<m && curr.y<n && grid[curr.x+1][curr.y]==1 && !visited[curr.x+1][curr.y]){
                    queue.offer(new Pair(curr.x+1, curr.y));
                    visited[curr.x+1][curr.y] = true;
                }

                if (curr.y+1<n && curr.x< m && grid[curr.x][curr.y+1]==1 && !visited[curr.x][curr.y+1]){
                    queue.offer(new Pair(curr.x, curr.y+1));
                    visited[curr.x][curr.y+1]=true;
                }
            }
        }
        return true;
    }

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
