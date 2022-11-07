class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (solve(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '$')
            return false;
        char temp = board[i][j];

        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] = '$';
        if (solve(board, word, index + 1, i - 1, j) ||
                solve(board, word, index + 1, i + 1, j) ||
                solve(board, word, index + 1, i, j + 1) ||
                solve(board, word, index + 1, i, j - 1))
            return true;

        board[i][j] = temp;

        return false;
    }
}
