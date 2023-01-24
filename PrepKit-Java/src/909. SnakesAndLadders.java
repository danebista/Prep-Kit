public class 909. SnakesAndLadders {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            reverseBoard(board);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            int steps =0;
            HashSet<Integer> visited = new HashSet<>();
            visited.add(1);
            
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i=0; i< size; i++){
                    Integer curr = queue.poll();
                    if (curr==board.length * board.length) return steps;
                    for (int j=1; j<=6; j++){
                        Integer next = j+curr;
                        int[] res = coordinateConverter(next, board);
                        if (next > board.length * board.length) continue;
                        if (board[res[0]][res[1]] != -1) {
                            next = board[res[0]][res[1]];
                        }
                        if (!visited.contains(next)){
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
                steps++;
            }
    
            return -1;
        }
    
        public void reverseBoard(int[][] board){
            for (int i=0; i< board.length/2; i++){
                for (int j=0; j< board[0].length; j++){
                    int[] temp = board[i].clone();
                    board[i][j] = board[board.length-1-i][j];
                    board[board.length-1-i][j] = temp[j];
                }
            }
        }
    
        public int[] coordinateConverter(int pos, int[][]board){
            //O based indexing
            int row = (pos-1) / board.length;
            int col = (pos-1) % board.length;
    
            if (row%2==1) {
                col = board.length-1-col;
            }
    
            return new int[]{row, col};
        }
    
        
    }
}
