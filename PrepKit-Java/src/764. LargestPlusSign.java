class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
       int[][] mat = new int[n][n];
       
       for (int[]temp:mat){
           Arrays.fill(temp,1);
       } 

       for (int i=0; i< mines.length; i++){
         mat[mines[i][0]][mines[i][1]]=0;
       }
       int res=0;

        for (int i=0; i< n; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j]==1){
                    int val=1;
                    while (i-val>=0 && i+val<n && j-val>=0 & j+val<n && mat[i][j-val]==1
                    && mat[i][j+val]==1 && mat[i-val][j]==1 && mat[i+val][j]==1){
                        val+=1;
                        
                    } 
                    res=Math.max(res, val);
                }
            }
        }

        return res;
    }
}
