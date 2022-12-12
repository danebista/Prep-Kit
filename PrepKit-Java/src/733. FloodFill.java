class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] copy = new int[image.length][image[0].length];

        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                copy[x][y] = image[x][y];
            }
        }

        helper(copy, sr, sc, color, initialColor);
        return copy;
    }

    public void helper(int[][] copy, int x, int y, int color, int initialColor) {
        if (x < 0 || x > copy.length - 1 || y < 0 || y > copy[0].length - 1)
            return;
        if (copy[x][y] == initialColor && copy[x][y] != color) {
            copy[x][y] = color;
            helper(copy, x - 1, y, color, initialColor);
            helper(copy, x, y - 1, color, initialColor);
            helper(copy, x + 1, y, color, initialColor);
            helper(copy, x, y + 1, color, initialColor);
        }
    }
}
