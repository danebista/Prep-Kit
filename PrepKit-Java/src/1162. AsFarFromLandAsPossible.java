class Solution {
    public int maxDistance(int[][] grid) {
       Queue<Pair> queue = new LinkedList<>();
       for (int i=0; i<grid.length; i++){
           for (int j=0; j<grid[0].length; j++){
               if (grid[i][j]==1){
                   grid[i][j]=-1;
                   queue.add(new Pair(i,j));
               }
           }
       }
       
       int steps =0;
       Pair[]dx = new Pair[]{new Pair(1,0), new Pair(-1,0), new Pair(0,1), new Pair(0, -1)};
       while (!queue.isEmpty()){
           int size = queue.size();
           for (int i=0; i< size; i++){
               Pair curr = queue.poll();
               for (Pair d:dx){
                   int newX = curr.i+d.i;
                   int newY = curr.j+d.j;

                   if (newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length 
                   && grid[newX][newY]==0){
                       queue.add(new Pair(newX, newY));
                       grid[newX][newY]=-1;
                   }
               }

           }
           steps++;
       }

       return steps == 1 ? -1 : steps - 1;
    }

    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}