class Solution {
    public int numSquares(int n) {
        // return helper(n);
        int[] dp = new int[n + 1];
        for (int target = 1; target <= n; target++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= target; i++) {
                if (target - i * i < 0)
                    break;
                min = Math.min(min, 1 + dp[target - i * i]);
            }
            dp[target] = min;
        }

        return dp[n];
    }
}

class Solution {
    public int numSquares(int n) {
        // return helper(n);
        int[][] dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(n, n, dp);
    }

    public int helper(int index, int target, int[][] ds) {
        if (index <= 0) {
            if (target == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (ds[index][target] != -1)
            return ds[index][target];
        int pick = Integer.MAX_VALUE;
        if (target - index * index >= 0) {
            int newTarget = target - index * index;
            pick = 1 + helper(index, newTarget, ds);
        }
        int notPick = helper(index - 1, target, ds);

        return ds[index][target] = Math.min(pick, notPick);
    }
}

class Solution {
    public int numSquares(int n) {
        // return helper(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    public int helper(int target, int[] dp) {
        if (target == 0) {
            return 0;
        }

        if (dp[target] != -1)
            return dp[target];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= target; i++) {
            if (target - i * i < 0)
                break;
            min = Math.min(min, 1 + helper(target - i * i, dp));
        }

        return dp[target] = min;
    }
}
