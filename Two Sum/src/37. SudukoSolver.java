class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        int row = -1;
        int column = -1;
        boolean outerflag = false;

        for (int i = 0; i < board.length; i++) {
            if (outerflag)
                break;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    column = j;
                    outerflag = true;
                    break;
                }
            }
        }

        if (row == -1 && column == -1)
            return true;

        for (int i = 1; i <= 9; i++) {
            if (!isValid(board, row, column, i))
                continue;

            board[row][column] = Character.forDigit(i, 10);
            if (solve(board))
                return true;

            board[row][column] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int column, int i) {
        return isValidRow(board, row, column, i) && isValidColumn(board, row, column, i)
                && isValidCrossSection(board, row, column, i);
    }

    public boolean isValidRow(char[][] board, int row, int column, int val) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != '.' && i != column && board[row][i] - '0' == val)
                return false;
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int row, int column, int val) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][column] != '.' && i != row && board[i][column] - '0' == val)
                return false;
        }
        return true;
    }

    public boolean isValidCrossSection(char[][] board, int row, int column, int val) {
        int x = row / 3;
        int y = column / 3;

        for (int i = x * 3; i < x * 3 + 3; i++) {
            for (int j = y * 3; j < y * 3 + 3; j++) {
                if (board[i][j] != '.' && i != row && j != column &&
                        board[i][j] - '0' == val)
                    return false;
            }
        }
        return true;
    }

}
