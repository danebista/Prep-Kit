class Solution {
    public boolean validTicTacToe(String[] board) {
        // Since X goes first:
        // The number of X must be greater than or equal to O by 1;
        // If X Wins, then the number of XChars - OChars must be 1;
        // If O Wins, then the number of XChars-OChars must be 0;
        int xcount=0;
        int ycount=0;
        boolean xWins = false;
        boolean yWins = false;
        StringBuilder firstDiagonal = new StringBuilder();
        StringBuilder secondDiagonal = new StringBuilder();
        int N = 3;
        for (int i=0; i<3; i++){
            for (char c: board[i].toCharArray()){
                if (c == 'O') ycount++;
                if (c == 'X') xcount++;
            }
            //horizontal wins
            if (board[i].equals("XXX")){
                xWins = true;
            }
            //horizontal wins
            if (board[i].equals("OOO")){
                yWins = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(board[0].charAt(i));
            sb.append(board[1].charAt(i));
            sb.append(board[2].charAt(i));
            if (sb.toString().equals("XXX")){
                xWins = true;
            }
            if (sb.toString().equals("OOO")){
                yWins=true;
            }

            firstDiagonal.append(board[i].charAt(i));

            secondDiagonal.append(board[N-1-i].charAt(i));
        }
        String diagOne = firstDiagonal.toString();
        String diagTwo = secondDiagonal.toString();

        if (diagOne.equals("XXX")) xWins=true;
        if (diagOne.equals("OOO")) yWins=true;
        if (diagTwo.equals("XXX")) xWins=true;
        if (diagTwo.equals("OOO")) yWins=true;
        
        if (xWins && !yWins && xcount-ycount==1) return true;
        if (xWins && yWins) return false;
        if (yWins &&  !xWins && xcount==ycount) return true;
        if (!xWins && !yWins && xcount>=ycount && xcount-ycount<=1 ) return true;
        return false;
    }
}

