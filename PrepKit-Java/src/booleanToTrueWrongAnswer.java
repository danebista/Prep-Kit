//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int countWays(int N, String S) {
        // code here
        long[][][] dp = new long[N][N][2];
        for (long[][] ds : dp) {
            for (long[] d : ds) {
                Arrays.fill(d, -1);
            }
        }
        return (int) helper(S, 0, N - 1, 1, dp);

    }

    public static long helper(String s, int i, int j, int chooser, long[][][] dp) {
        if (i > j)
            return 0;

        if (i == j) {
            if (chooser == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j][chooser] != -1)
            return dp[i][j][chooser];

        long ways = 0;
        long mod = 1000000007;
        for (int l = i + 1; l <= j - 1; l = l + 2) {
            long lft = helper(s, i, l - 1, 1, dp);
            long lff = helper(s, i, l - 1, 0, dp);
            long rft = helper(s, l + 1, j, 1, dp);
            long rff = helper(s, l + 1, j, 0, dp);

            if (s.charAt(l) == '&') {
                if (chooser == 1) {
                    ways += (lft * rft) % mod;
                } else {
                    ways += ((lft * rff) % mod + (lff * rft) % mod + (lff * rff) % mod) % mod;
                }
            } else if (s.charAt(l) == '|') {
                if (chooser == 1) {
                    ways += ((lft * rft) % mod + (lft * rff) % mod + (lff * rft) % mod) % mod;
                } else {    
                    ways += (lff * rff) % mod;
                }
            } else {
                if (chooser == 1) {
                    ways += ((lft * rff) % mod + (lff * rft) % mod) % mod;
                } else {
                    ways += ((lft * rft) % mod + (lff * rff) % mod) % mod;
                }
            }
        }

        return dp[i][j][chooser] = ways;
    }
}
