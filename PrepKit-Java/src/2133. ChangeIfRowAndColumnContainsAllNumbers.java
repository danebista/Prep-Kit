import java.util.*;

class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<String> hashset = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String key1 = i + "row" + matrix[i][j];
                String key2 = j + "col" + matrix[i][j];
                if (!hashset.add(key1) || !hashset.add(key2))
                    return false;
            }
        }
        return true;

    }
}

class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int index = Math.abs(matrix[i][j]) - 1;
                if (matrix[i][index] < 0)
                    return false;
                matrix[i][index] = -matrix[i][index];
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int index = Math.abs(matrix[i][j]) - 1;
                if (matrix[index][j] > 0)
                    return false;
                matrix[index][j] = Math.abs(matrix[index][j]);
            }
        }

        return true;

    }
}