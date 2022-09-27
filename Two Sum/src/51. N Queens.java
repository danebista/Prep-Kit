import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] queensBoard = new char[n][n];
        List<List<String>> result = new ArrayList();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                queensBoard[r][c] = '.';
            }
        }
        List<int[]> queens = new ArrayList();

        helper(0, result, queensBoard, queens);

        return result;
    }

    public void helper(int c, List<List<String>> result, char[][] queensBoard,
            List<int[]> queens) {

        if (queensBoard.length == queens.size()) {
            List<String> rows = new ArrayList();
            for (char[] row : queensBoard) {
                rows.add(new String(row));
            }

            result.add(rows);
        }

        for (int i = 0; i < queensBoard.length; i++) {
            if (isValid(i, c, queens)) {
                queensBoard[i][c] = 'Q';
                queens.add(new int[] { i, c });
                helper(c + 1, result, queensBoard, queens);
                queensBoard[i][c] = '.';
                queens.remove(queens.size() - 1);
            }
        }
    }

    public boolean isValid(int r, int c, List<int[]> queens) {
        for (int[] queen : queens) {
            int dx = Math.abs(queen[0] - r);
            int dy = Math.abs(queen[1] - c);
            if (dx == 0 || dy == 0 || dx == dy)
                return false;
        }

        return true;
    }
}
