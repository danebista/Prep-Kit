class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, graph, color) == false)
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int colors, int[][] graph, int[] color) {
        color[node] = colors;
        for (int i : graph[node]) {
            if (color[i] == -1) {
                int newColor = colors == 0 ? 1 : 0;
                if (dfs(i, newColor, graph, color) == false)
                    return false;
            } else if (color[i] == colors) {
                return false;
            }
        }

        return true;
    }
}
