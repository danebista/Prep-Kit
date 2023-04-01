class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] matrix = new int[m*n];
        int row = 0;
        int col= 0;
        int direc = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for (int i=0; i<m*n; i++){
            matrix[i] = mat[row][col];
            row+=dirs[direc][0];
            col+=dirs[direc][1];
            if (col>=n){
                col=n-1;
                row+=2;
                direc=1-direc;
            }
            
            if (row>=m){
                row = m-1;
                col+=2;
                direc=1-direc;
            }

            
        
            if (row<0){
                row=0;
                direc = 1-direc;
            }
            if (col<0){
                col=0;
                direc = 1-direc;
            }
            
        }

        return matrix;
    }
}
