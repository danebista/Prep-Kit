class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        return (int) ((power(4, n / 2, mod) * power(5, n - n / 2, mod)) % mod);
    }

    public long power(long x, long n, long mod) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * x) % mod;
                n = n - 1;
            } else {
                x = (x * x) % mod;
                n = n / 2;
            }
        }
        return ans;
    }
}
