class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if (board[i][board[0].length - 1] == 'O') {
                dfs(i, board[0].length - 1, board);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[board.length - 1][j] == 'O') {
                dfs(board.length - 1, j, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }

    }

    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] != 'O')
            return;

        board[i][j] = '1';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
