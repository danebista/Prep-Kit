
class Solution {
    public int mod = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1)
            return 1;

        long mx = (long) (Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm / 2;
        long sum = rec(sm, n);

        return (int) (sum * (mx % mod) % mod);
    }

    public long rec(long val, long n) {
        if (n == 0)
            return 1;
        long ans = 1;

        while (n > 0) {
            if (n % 2 != 0) {
                ans = ((ans % mod) * (val % mod)) % mod;
                n = n - 1;
            } else {
                val = ((val % mod) * (val % mod)) % mod;
                n = n / 2;
            }

        }

        return ans % mod;
    }
}
