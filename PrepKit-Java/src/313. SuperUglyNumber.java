class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes.length == 0 || n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] primeIndexes = new int[primes.length];
        long[] dp = new long[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[primeIndexes[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primeIndexes.length; j++) {
                if ((long) (dp[primeIndexes[j]] * primes[j]) == min) {
                    primeIndexes[j] += 1;
                }
            }
        }

        return (int) dp[n - 1];
    }
}
