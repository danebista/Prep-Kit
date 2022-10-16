class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxi = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                maxi += prices[i] - buy;
                buy = prices[i];
            } else {
                buy = Math.min(prices[i], buy);
            }
        }
        return maxi;
    }
}
