class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] DIRS = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        double[][] M0 = new double[N][N];
        double[][] N0N = new double[N][N];
        M0[r][c] = 1.0;
        
        for(int k = 0; k < K; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] dir : DIRS){
                        int newX = i - dir[0];
                        int newY = j - dir[1];
                        if(newX >= 0 && newX < N && newY >= 0 && newY < N){
                            N0N[newX][newY] += M0[i][j]/8.0;  
                        }
                    }
                }
            }
            M0 = N0N;
            N0N = new double[N][N];
        }
        
        double res = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                res += M0[i][j];
            }
        }
        
        return res;
    }
}

