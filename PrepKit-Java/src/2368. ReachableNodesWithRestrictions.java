class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<restricted.length;i++){
            int j = restricted[i];
            visited[j] = true;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        q.add(0);
        visited[0] = true;
        int count = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            

            for(int i=0;i<adj.get(x).size();i++){
                int nei = adj.get(x).get(i);
                if(!visited[nei]){
                    visited[nei] = true;
                    q.add(nei);
                    count++;
                }
            }
        }
        return count;
    }
}
