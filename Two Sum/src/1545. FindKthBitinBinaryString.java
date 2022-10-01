class Solution {
    public char findKthBit(int n, int k) {
        // System.out.println(findKth(n,k));
        return Integer.toString(findKth(n, k)).charAt(0);
    }

    public int findKth(int n, int k) {
        if (n == 1)
            return 0;

        int length = (int) Math.pow(2, n) - 1;

        if (k == length / 2 + 1)
            return 1;
        int mid = length / 2 + 1;
        if (k < mid) {

            return findKth(n - 1, k);
        }
        int index = length / 2 - (k - mid - 1);

        return 1 - findKth(n - 1, index);
    }
}
