class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int largest = 0;
        for (int row = -img1.length + 1; row < img1.length; row++) {
            for (int col = -img2.length + 1; col < img1.length; col++) {
                largest = Math.max(largest, overLapper(img1, img2, row, col));
            }
        }

        return largest;
    }

    public int overLapper(int[][] img1, int[][] img2, int rowOff, int colOff) {
        int count = 0;
        for (int row = 0; row < img1.length; row++) {
            for (int col = 0; col < img1[0].length; col++) {
                if ((row + rowOff) < 0 || (row + rowOff >= img1.length) || (col + colOff) < 0 ||
                        (col + colOff >= img1[0].length))
                    continue;
                if (img1[row][col] == 1 && img2[row + rowOff][col + colOff] == 1)
                    count++;
            }
        }
        return count;
    }
}
