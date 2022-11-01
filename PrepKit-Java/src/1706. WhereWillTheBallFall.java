class Solution {
    public int[] findBall(int[][] grid) {
        int curPos = 0;
        int nextPos = 0;
        int[] pos = new int[grid[0].length];
        for (int j=0; j< grid[0].length; j++){
            curPos = j;
            for (int i=0; i< grid.length; i++){
                nextPos = curPos +grid[i][curPos];
                if (nextPos<0 || nextPos> grid[0].length-1 || grid[i][curPos] != grid[i][nextPos]) {
                    curPos = -1;
                    break;
                }
                curPos = nextPos;
            }
            
            pos[j] = curPos;
        }
        
        return pos;
    }
}
