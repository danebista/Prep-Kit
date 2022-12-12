class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list1 = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            list1.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    list1.get(i).add(j);
                    list1.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                helper(i, list1, visited);
                count++;
            }
        }

        return count;
    }

    public void helper(int node, List<List<Integer>> list1, boolean[] visited) {

        visited[node] = true;
        for (Integer ns : list1.get(node)) {
            if (!visited[ns])
                helper(ns, list1, visited);
        }

    }
}
