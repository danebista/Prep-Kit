class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = offset * 2;
            }
            count[i] = 1 + count[i - offset];
        }
        return count;
    }
}

/*
 * 0000 - 0
 * 0001 - 1
 * 0010 - 1
 * 0011 - 2
 * 0100 -1+ dp[i-4]
 * 0101 -1+ dp[i-4]
 * 0110 - 1+dp[i-4]
 * 0111-1+dp[i-4]
 * 
 */
