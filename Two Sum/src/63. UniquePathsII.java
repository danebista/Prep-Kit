class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;

                } else {
                    int left = 0;
                    int right = 0;
                    if (i - 1 >= 0) {
                        left += obstacleGrid[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        right += obstacleGrid[i][j - 1];
                    }
                    obstacleGrid[i][j] = left + right;
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
