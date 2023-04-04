class Solution {
    int count;
    public int maximumRows(int[][] matrix, int numSelect) {
        count = 0;
        boolean[] visited = new boolean[matrix[0].length];
        
        helper(0, matrix, numSelect, visited);
        return count;
    }

    public void helper(int index, int[][] matrix, int k, boolean[] visited){
        if (index>= matrix[0].length){
            if (k!=0) return;
            int val = 0;
            for (int i=0; i< matrix.length; i++){
                boolean flag = true;
                for (int j=0; j< matrix[0].length; j++){
                    if (matrix[i][j]==1 && !visited[j]){
                        flag = false;
                        break;
                    }
                }
                if (flag) val++;
            }
            count = Math.max(count, val);

            return;
        }

        
        if (k>0){
            visited[index]= true;
            helper(index+1, matrix, k-1, visited);
            visited[index]= false;
        }
        
        helper(index+1, matrix, k, visited);
    }
}
