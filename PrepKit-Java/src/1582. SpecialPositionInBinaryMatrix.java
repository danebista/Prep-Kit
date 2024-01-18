class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int cols = mat[0].length;

        int res = 0; 

        for (int i=0; i< row; i++){
            for (int j=0; j< cols; j++){
                int cell = mat[i][j];
                if (cell == 1){
                    if (checkRowCol(mat, i, j)==true){
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private boolean checkRowCol(int[][] mat, int row, int col){
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i=col+1; i< cols; i++){
            if(mat[row][i] == 1) return false;
        }

        for (int i=col-1; i>=0; i--){
            if (mat[row][i] == 1) return false;
        }

        for (int i=row+1; i< rows; i++){
            if (mat[i][col]==1) return false;
        }

        for (int i=row-1; i>=0; i--){
            if (mat[i][col]==1) return false;
        }

        return true;
    }
}