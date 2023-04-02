class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int length = encodedText.length();
        int colLength = length/rows;
        Character [][] mat = new Character[rows][colLength];
        int k=0;
        int m=0;
        for (int i=0; i< mat.length; i++){
            for (int j=0; j< mat[0].length; j++){
                mat[i][j] = encodedText.charAt(m++);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j=0; j< colLength; j++){
            k = j;
            for (int i=0;i<mat.length; i++){
                if (k>= mat[0].length) break;
                res.append(mat[i][k]);
                k++;
            }
        }

        StringBuilder new_res = new StringBuilder();
        int fg=0;
        for(int i=res.length()-1;i>=0;i--) {
            
            if(fg==0 && res.charAt(i)==' ')
                continue;
            fg=1;
            new_res.append(res.charAt(i));
        }
        return new_res.reverse().toString();

    }
}
