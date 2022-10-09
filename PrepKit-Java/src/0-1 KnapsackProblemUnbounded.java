import java.util.*;
import java.io.*;

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];
        int[] curr = new int[w + 1];

        for (int wei = 0; wei <= w; wei++) {
            prev[wei] = ((int) (wei / weight[0])) * profit[0];
        }
        for (int no = 1; no < n; no++) {
            for (int wei = 0; wei <= w; wei++) {
                int notTake = prev[wei];
                int take = Integer.MIN_VALUE;
                if (wei - weight[no] >= 0) {
                    take = profit[no] + curr[wei - weight[no]];
                }
                curr[wei] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[w];
    }
}
