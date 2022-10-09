class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        int l = 0;
        int r = nums1.length;
        int total = nums1.length + nums2.length;

        while (true) {
            int i = (l + r) / 2;

            int j = (total + 1) / 2 - i;

            int l1 = i - 1 >= 0 ? nums1[i - 1] : Integer.MIN_VALUE;

            int l2 = j - 1 >= 0 ? nums2[j - 1] : Integer.MIN_VALUE;

            int r1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;

            int r2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

    }
}
