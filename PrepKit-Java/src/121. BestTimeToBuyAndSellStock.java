class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxi) {
                maxi = prices[i] - min;
            }

            min = Math.min(min, prices[i]);
        }

        return maxi;
    }
}
