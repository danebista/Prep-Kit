class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean one = true;
        boolean two = true;
        boolean three = true;
        boolean four = true;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[j][mat.length - 1 - i]) {
                    one = false;
                }
                if (mat[i][j] != target[mat.length - 1 - i][mat[0].length - 1 - j]) {
                    two = false;
                }
                if (mat[i][j] != target[mat[0].length - 1 - j][i]) {
                    three = false;
                }
                if (mat[i][j] != target[i][j]) {
                    four = false;
                }
            }
        }

        return one || two || three || four;
    }
}
