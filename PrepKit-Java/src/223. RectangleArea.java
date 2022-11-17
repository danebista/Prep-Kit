class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int A = bx2 > bx1 ? (bx2 - bx1) : (bx1 - bx2);
        int B = by2 > by1 ? (by2 - by1) : (by1 - by2);

        int C = ax2 > ax1 ? (ax2 - ax1) : (ax1 - ax2);
        int D = ay2 > ay1 ? (ay2 - ay1) : (ay1 - ay2);

        int common_1 = Math.max(Math.min(ax2, bx2) - Math.max(bx1, ax1), 0);// Disjoint cases are 0
        int common_2 = Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);
        return ((A * B) + (C * D)) - (common_1 * common_2);

    }
}
