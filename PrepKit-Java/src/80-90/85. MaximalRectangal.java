class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] matrix1 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix1[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0)
                    continue;
                if (matrix1[i][j] == 0)
                    continue;
                matrix1[i][j] += matrix1[i - 1][j];
            }

            max = Math.max(max, calculateLargestArea(matrix1[i]));
        }

        return max;
    }

    public int calculateLargestArea(int[] matrix) {
        Stack<Integer> stack = new Stack();
        int[] left = new int[matrix.length];
        int[] right = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            while (!stack.isEmpty() && matrix[stack.peek()] >= matrix[i])
                stack.pop();
            if (stack.isEmpty())
                left[i] = 0;
            else {
                left[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && matrix[stack.peek()] >= matrix[i])
                stack.pop();
            if (stack.isEmpty())
                right[i] = matrix.length - 1;
            else {
                right[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, matrix[i] * (right[i] - left[i] + 1));
        }

        return max;
    }
}
