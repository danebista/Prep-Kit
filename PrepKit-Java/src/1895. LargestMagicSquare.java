class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length; 
        int n=grid[0].length;
        int[][] row = new int[m][n];
        int[][] cols =new int[m][n];
        int[][]diag1 = new int[m][n];
        int[][]diag2 = new int[m][n];
        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                row[i][j] = grid[i][j]+(j-1>=0?row[i][j-1]:0);
            }
        }
        for (int j=0; j< n; j++){
            for (int i=0; i<m; i++){
                cols[i][j] = grid[i][j]+(i-1>=0?cols[i-1][j]:0);
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                diag1[i][j]=grid[i][j]+(i-1>=0 && j-1>=0? diag1[i-1][j-1]:0);
                diag2[i][j] = grid[i][j]+(i-1>=0 && j+1<n? diag2[i-1][j+1]:0);
            }
        }
        int max=0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                for (int i1=i, j1=j; i1<m && j1<n; i1++, j1++){
                    int reqSum = row[i][j1]-(j-1>=0? row[i][j-1]:0);
                    if (!findRow(row,i,j, i1, j1, reqSum)) continue;
                    if (!findCol(cols,i,j, i1, j1, reqSum)) continue;
                    if (!findDiag(diag1,i,j, i1, j1, reqSum)) continue;
                     if (!findAnti(diag2,i,j, i1, j1, reqSum)) continue;

                     max= Math.max(max, i1-i+1);
                }
            }
        }
        return max;


    }
    public boolean findRow(int rowSum[][],int r1,int c1,int r2,int c2,int reqSum){
    for(int i = r1; i <= r2; i++){
        int sum = rowSum[i][c2] - (c1 - 1 >= 0 ? rowSum[i][c1 - 1] : 0);        
        if(sum != reqSum) return false;
    }
    return true;
}

public boolean findCol(int colSum[][],int r1,int c1,int r2,int c2,int reqSum){
    for(int j = c1; j <= c2; j++){
        int sum = colSum[r2][j] - (r1 - 1 >= 0 ? colSum[r1 - 1][j] : 0);        
        if(sum != reqSum) return false;
    }
    return true;
}

public boolean findDiag(int diag[][],int r1,int c1,int r2,int c2,int reqSum){
    return (diag[r2][c2] - (r1 - 1 >= 0 && c1 - 1 >= 0 ? diag[r1 - 1][c1 - 1] : 0)) == reqSum;
}

public boolean findAnti(int antiDiag[][],int r1,int c1,int r2,int c2,int reqSum){
    return (antiDiag[r2][c1] - (r1 - 1 >= 0 && c2 + 1 < antiDiag[0].length ? antiDiag[r1 - 1][c2 + 1] : 0)) == reqSum;
}
}
