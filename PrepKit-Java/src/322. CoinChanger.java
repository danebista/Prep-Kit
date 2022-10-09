class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) 1e9;
        }
        for (int index = 1; index < coins.length; index++) {
            for (int am = 0; am <= amount; am++) {
                int notPick = 0 + prev[am];
                int pick = (int) 1e9;
                if (am - coins[index] >= 0) {
                    pick = 1 + curr[am - coins[index]];
                }
                curr[am] = Math.min(notPick, pick);
            }
            prev = curr.clone();
        }

        return prev[amount] == (int) 1e9 ? -1
                : prev[amount];
    }
}
