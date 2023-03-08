class NumMatrix {
    int[][] matrix1;
    public NumMatrix(int[][] matrix) {
        matrix1 = new int[matrix.length][matrix[0].length];

        for (int i=0; i< matrix.length; i++){
            for (int j=0; j<  matrix[0].length; j++){
                int val = matrix[i][j];
                if (i-1>=0) val+=matrix1[i-1][j];
                if (j-1>=0) val+=matrix1[i][j-1];
                if (i-1>=0 && j-1>=0) val-=matrix1[i-1][j-1];

                matrix1[i][j] = val;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = matrix1[row2][col2];
        if (row1-1>=0) val-=matrix1[row1-1][col2];
        if (col1-1>=0) val-=matrix1[row2][col1-1];
        if (row1-1>=0 && col1-1>=0) val+=matrix1[row1-1][col1-1];
        return val;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */