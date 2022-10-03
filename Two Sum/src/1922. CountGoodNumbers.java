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

class Solution {
    public int mod = 1_000_000_007;
    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        
        long mx = (long)(Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm/2;
        long sum = rec(sm, n);
        
        return (int)(sum * (mx % mod) % mod); 
    }
    
    public long rec(long val, long n) {
        if (n == 0) return 1;
        long ans = 1;
        while (n>0){
            if (n%2==1){
                ans = (ans%mod * val%mod)%mod;
                n=n-1;
            }
            else {
                val = (val%mod * val%mod)%mod;
                n=n/2;
            }
        }
        return ans%mod;
    }
}
