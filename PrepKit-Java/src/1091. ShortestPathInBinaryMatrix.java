class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][]visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0]==0){
            queue.offer(new Pair(0,0));
            visited[0][0] = true;
        } 
        int steps=-1;
        int[]dx=new int[]{0,1,1,1,0,-1,-1,-1};
        int[]dy=new int[]{1,1,0,-1,-1,-1,0,1};

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++){
                Pair curr = queue.poll();
                if (curr.x==grid.length-1. && curr.y==grid.length-1) return steps+2;
                for (int g=0; g<8; g++){
                    int tempX = curr.x + dx[g];
                    int tempY = curr.y + dy[g];
                    if (tempX<0 || tempY<0 || tempX>=grid.length
                    || tempY>=grid.length ||visited[tempX][tempY] || grid[tempX][tempY]!=0) continue;
                    queue.offer(new Pair(tempX, tempY));
                    visited[tempX][tempY] = true;
                }
            }

            steps++;
        }

        return -1;

    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
