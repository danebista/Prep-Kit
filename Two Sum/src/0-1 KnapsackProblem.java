class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[] prev = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int w = W; w >= 0; w--) {
                int notTake = 0 + prev[w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[i]) {
                    take = val[i] + prev[w - wt[i]];
                }
                prev[w] = Math.max(take, notTake);
            }
        }
        return prev[W];
        // your code here
    }
}
