class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] matrix1 = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    continue;
                matrix1[i][j] = Character.getNumericValue(matrix[i][j]);
                maxLen = Math.max(maxLen, matrix1[i][j]);

                if (i - 1 >= 0 && j - 1 >= 0) {
                    matrix1[i][j] += Math.min(matrix1[i - 1][j], Math.min(matrix1[i][j - 1], matrix1[i - 1][j - 1]));
                    maxLen = Math.max(maxLen, matrix1[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
