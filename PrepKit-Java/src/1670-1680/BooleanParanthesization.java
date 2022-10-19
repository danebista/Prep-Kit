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
        int[][][] dp = new int[N][N][2];
        for (int[][] ds : dp) {
            for (int[] d : ds) {
                Arrays.fill(d, -1);
            }
        }
        return helper(S, 0, N - 1, 1, dp);

    }

    public static int helper(String s, int i, int j, int chooser, int[][][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j][chooser] != -1)
            return dp[i][j][chooser];

        if (i == j) {
            if (chooser == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }
        int ways = 0;
        for (int l = i + 1; l <= j - 1; l = l + 2) {
            int lft = helper(s, i, l - 1, 1, dp);
            int lff = helper(s, i, l - 1, 0, dp);
            int rft = helper(s, l + 1, j, 1, dp);
            int rff = helper(s, l + 1, j, 0, dp);

            if (s.charAt(i) == '&') {
                if (chooser == 1) {
                    ways += lft * rft;
                } else {
                    ways += lft * rff + lff * rft + lff * rff;
                }
            } else if (s.charAt(i) == '|') {
                if (chooser == 1) {
                    ways += lft * rft + lft * rff + lff * rft;
                } else {
                    ways += lft * rft;
                    ;
                }
            } else {
                if (chooser == 1) {
                    ways += lft * rff + lff * rft;
                } else {
                    ways += lft * rft + lff * rff;
                }
            }
        }

        return dp[i][j][chooser] = ways;
    }
}
