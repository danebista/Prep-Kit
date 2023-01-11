class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i< n; i++){
           adj.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(adj, 0, -1, hasApple);
        
    }

    public int dfs(List<List<Integer>> adj, int curr, int parent, List<Boolean> hasApple){
        int time=0;

        for (Integer child: adj.get(curr)){
            if (child == parent) continue;
            int childTime = dfs(adj, child, curr, hasApple);
            
            if (childTime > 0 || hasApple.get(child)){
                time+= 2 + childTime;
            }
        }

        return time;
    }
}
