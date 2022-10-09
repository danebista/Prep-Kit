class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n % 2 == 1)
            return false;
        long i = 1;
        while (i < n) {
            i = i * 2;
        }
        return i == n;
    }
}
