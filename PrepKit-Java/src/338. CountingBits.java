class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        int offset = 1;
        count[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = offset * 2;
            }
            count[i] = 1 + count[i - offset];
        }
        return count;
    }
}
