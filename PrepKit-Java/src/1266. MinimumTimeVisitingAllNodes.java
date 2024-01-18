class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[0][0];
        int y2 = points[0][1];
        int totalTime = 0;
        for (int[] point : points) {
            x2 = point[0];
            y2 = point[1];
            totalTime += getTime(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
        return totalTime;
    }
    
    private int getTime(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
