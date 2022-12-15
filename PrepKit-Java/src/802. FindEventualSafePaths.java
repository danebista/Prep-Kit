class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        int[] currentPath = new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                isCyclePath(graph, i, visited, currentPath);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentPath.length; i++) {
            if (currentPath[i] == 0)
                result.add(i);
        }

        return result;
    }

    public boolean isCyclePath(int[][] graph, int node, int[] visited, int[] currentPath) {
        visited[node] = 1;
        currentPath[node] = 1;
        for (int i : graph[node]) {
            if (visited[i] == 0) {
                if (isCyclePath(graph, i, visited, currentPath))
                    return true;
            } else if (visited[i] == 1 && currentPath[i] == 1) {
                return true;
            }
        }
        currentPath[node] = 0;
        return false;
    }
}
