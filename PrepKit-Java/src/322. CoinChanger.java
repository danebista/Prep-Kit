class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : (int) 1e9;
        }
        for (int index = 1; index < coins.length; index++) {
            for (int am = 0; am <= amount; am++) {
                int take = (int) 1e9;
                if (am - coins[index] >= 0) {
                    take = 1 + dp[index][am - coins[index]];
                }
                int notTake = dp[index - 1][am];

                dp[index][am] = Math.min(take, notTake);
            }
        }
        if (dp[coins.length - 1][amount] == 1e9)
            return -1;
        return dp[coins.length - 1][amount];
    }

    public int helper(int[] coins, int amount, int index) {
        if (index == 0) {
            if (amount % coins[index] == 0)
                return amount / coins[index];
            return (int) 1e9;
        }
        int take = (int) 1e9;
        if (amount - coins[index] >= 0) {
            take = 1 + helper(coins, amount - coins[index], index);
        }
        int notTake = helper(coins, amount, index - 1);

        return Math.min(take, notTake);
    }

}

 public int coinChange(int[] coins, int amount) {
      int[] prev = new int[amount+1];
      int[] curr = new int[amount+1];

      for (int i=0; i<=amount; i++){
          prev[i] = i% coins[0]==0? i/coins[0]:(int)1e9;
      }
      for (int index=1; index< coins.length; index++){
          for (int am=0; am<= amount; am++){
              int take = (int)1e9;
              if (am-coins[index]>=0){
                take = 1+curr[am-coins[index]];
              }
              int notTake = prev[am];

              curr[am] = Math.min(take, notTake);
          }
          prev = curr.clone();
      }
      if (prev[amount]==1e9) return -1;
      return prev[amount];
    }