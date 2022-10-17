class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        int[] curr = new int[2];
        int[] ahead = new int[2];
        ahead[0] = 0;
        ahead[1] = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    curr[j] = Math.max(-prices[i] + ahead[1], 0 + ahead[0]);
                } else {
                    curr[j] = Math.max(prices[i] + ahead[0], 0 + ahead[1]);
                }
            }
            ahead = curr.clone();
        }
        return curr[0];

    }
}
