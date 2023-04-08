class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
         helper(score, k, 0, score.length-1);
         return score;
    }
    
    public void helper(int[][] score, int k, int l, int r){
        if (l>=r) return;
        int m =l+(r-l)/2;
        helper(score, k, l, m);
        helper(score, k, m+1, r);
        mergeSort(score, k, l, m, r);
    }

    public void mergeSort(int[][]score, int k, int l, int m, int r){
       
        int[][] temp1 = new int[m-l+1][score[0].length];
        int[][] temp2 = new int[r-(m+1)+1][score[0].length];
        for (int i=0; i<temp1.length; i++){
            for (int j=0; j< score[0].length; j++){
                temp1[i][j]=score[l+i][j];
        
            }
            
        }
        for (int i=0; i<temp2.length; i++){
            for (int j=0; j<score[0].length; j++){
                temp2[i][j] = score[m+1+i][j];
            }
        }

        int i=0;
        int j=0;
        int t=l;
        while (i<temp1.length && j<temp2.length){
            if (temp1[i][k]> temp2[j][k]){
                for (int o=0; o< score[0].length; o++){
                    score[t][o] = temp1[i][o];
                     
                }  
                t++;
                i++;
            }
            else{
                for (int o=0; o< score[0].length; o++){
                    score[t][o]=temp2[j][o];
                }  
                t++;
                j++;
               
            }
        }
        while (i<temp1.length){
            for (int o=0; o< score[0].length; o++){
                    score[t][o] = temp1[i][o];
            } 
            t++; 
            i++;
        }
        
        while (j<temp2.length){
            for (int o=0; o< score[0].length; o++){
                    score[t][o]=temp2[j][o];
            }  
            t++;
            j++;
        }
    }
}