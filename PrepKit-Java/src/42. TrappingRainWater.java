class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 1)
            return 0;

        int lmax = height[0];
        int rmax = height[height.length - 1];
        int l = 1;
        int r = height.length - 2;
        int res = 0;
        while (l <= r) {
            if (lmax < rmax) {
                if (lmax - height[l] > 0) {
                    res += lmax - height[l];
                }
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                if (rmax - height[r] > 0) {
                    res += rmax - height[r];
                }
                rmax = Math.max(rmax, height[r]);
                r--;
            }
        }

        return res;
    }
}
