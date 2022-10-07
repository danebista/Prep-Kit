class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left_min = Integer.MAX_VALUE;
                int top_below = Integer.MAX_VALUE;
                int top_right = Integer.MAX_VALUE;
                if (i - 1 >= 0 && i - 1 < matrix[0].length
                        && j - 1 >= 0 && j - 1 < matrix[0].length) {
                    left_min = matrix[i - 1][j - 1];
                }
                if (i - 1 >= 0 && i - 1 < matrix[0].length) {
                    top_below = matrix[i - 1][j];
                }
                if (i - 1 >= 0 && i - 1 < matrix[0].length &&
                        j + 1 >= 0 && j + 1 < matrix[0].length) {
                    top_right = matrix[i - 1][j + 1];
                }
                matrix[i][j] = matrix[i][j] +
                        Math.min(left_min, Math.min(top_below, top_right));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[matrix.length - 1][j] < min) {
                min = matrix[matrix.length - 1][j];
            }
        }

        return min;
    }
}
