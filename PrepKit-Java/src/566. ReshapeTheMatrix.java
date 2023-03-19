class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res=new int[r][c];
        
        for (int[] ro:res){
            Arrays.fill(ro, -1001);
        }

        int k=0;
        int l=0;

        for (int i=0; i< mat.length; i++){
            for (int j=0; j< mat[0].length; j++){
                if (l==c){
                   k++;
                   l=0;
                }
                if (k==r) return mat;
               
                res[k][l++]=mat[i][j];
            }
        }
        if (res[res.length-1][res[0].length-1]==-1001) return mat;
        return res;
        
    }
}
