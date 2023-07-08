class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        // if number of bags = number of marbles
        // minimum score = sum of cost of each bag/marble
        // maximum score = sum of cost of each bag/marble
        // so both are equal hence difference is 0
        if (k == n) {
            return 0;
        }
        int minCost = weights[0]+weights[n-1];
        int maxCost = weights[0]+weights[n-1];
        
        int[] costs = new int[n-1];
        for (int i = 0; i < n - 1; i++) { 
            costs[i] = weights[i] + weights[i+1];
        }
        
        Arrays.sort(costs);
        
        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += costs[i];
            max += costs[n-i-2];    
            // length of costs is n-1 
            // so last index is n-1-1 = n-2
        }
        
        return max - min;
    }
}
