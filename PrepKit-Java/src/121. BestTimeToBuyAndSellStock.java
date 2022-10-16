class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buy > 0) {
                maxi = Math.max(prices[i] - buy, maxi);
            } else {
                buy = prices[i];
            }
        }

        return maxi;
    }
}
