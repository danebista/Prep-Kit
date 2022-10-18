import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        helper(nums, result, new ArrayList(), 0);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result,
            List<Integer> current, int index) {

        if (index >= nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        helper(nums, result, current, index + 1);
        current.remove(Integer.valueOf(nums[index]));
        helper(nums, result, current, index + 1);
    }
}

// Tabulation Method
class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        int m = grid[0].length;
        for (int j1 = 0; j1 < grid[0].length; j1++) {
            for (int j2 = 0; j2 < grid[0].length; j2++) {
                if (j1 == j2) {
                    dp[grid.length - 1][j1][j2] = grid[grid.length - 1][j1];
                } else {
                    dp[grid.length - 1][j1][j2] = grid[grid.length - 1][j1] + grid[grid.length - 1][j2];
                }
            }
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maximum = 0;
                    for (int a1 = -1; a1 <= 1; a1++) {
                        for (int b1 = -1; b1 <= 1; b1++) {
                            if (j1 == j2) {
                                maximum = Math.max(maximum,
                                        (j1 + a1 >= 0 && j1 + a1 < m && j2 + b1 >= 0
                                                && j2 + b1 < m) ? grid[i][j1] + dp[i + 1][j1 + a1][j2 + b1] : 0);
                            } else {
                                maximum = Math.max(maximum,
                                        (j1 + a1 >= 0 && j1 + a1 < m && j2 + b1 >= 0 && j2 + b1 < m)
                                                ? grid[i][j1] + grid[i][j2] + dp[i + 1][j1 + a1][j2 + b1]
                                                : 0);
                            }
                        }
                    }
                    dp[i][j1][j2] = maximum;
                }
            }
        }
        return dp[0][0][grid[0].length - 1];

    }
}
