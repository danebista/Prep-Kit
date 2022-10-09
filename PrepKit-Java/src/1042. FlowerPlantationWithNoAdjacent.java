import java.util.*;

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color = new int[n];
        List<List<Integer>> adj = new ArrayList();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (int[] path : paths) {
            adj.get(path[0] - 1).add(path[1] - 1);
            adj.get(path[1] - 1).add(path[0] - 1);
        }

        helper(adj, n, 0, color);

        return color;
    }

    public boolean helper(List<List<Integer>> adj, int n, int startNode, int[] color) {
        if (startNode == n)
            return true;

        for (int i = 1; i <= n; i++) {
            if (isValid(adj, color, i, startNode)) {
                color[startNode] = i;
                if (helper(adj, n, startNode + 1, color))
                    return true;
                color[startNode] = 0;
            }
        }
        return false;
    }

    public boolean isValid(List<List<Integer>> adj, int[] color, int i, int startNode) {
        for (Integer neigh : adj.get(startNode)) {
            if (color[neigh] == i)
                return false;
        }

        return true;
    }
}
