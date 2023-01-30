class Solution {
    public int numSubmat(int[][] mat) {
        for (int i=0; i< mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if (mat[i][j]!=0 && j>0){
                    mat[i][j]+= mat[i][j-1];
                }
            }
        }
        int res=0;
        for (int i=0; i< mat.length; i++){
            for (int j=0; j< mat[0].length; j++){
                int min = Integer.MAX_VALUE;
                for (int k=i; k<mat.length; k++){
                    min=Math.min(min, mat[k][j]);
                    res+=min;
                }
                
            }
        }

        return res;
    }
}
