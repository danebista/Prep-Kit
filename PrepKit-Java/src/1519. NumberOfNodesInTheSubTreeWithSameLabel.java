class Solution {
    int[] result;
    Set<Integer> visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        visited = new HashSet<>();
        result = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(adj,labels, 0);

        return result;
    }

    public int[] dfs(List<List<Integer>> adj, String labels, int node){
        int[] count = new int[26];
        visited.add(node);
        
        for (Integer child: adj.get(node)){
            if (visited.contains(child)) continue;
            int[] dfsOut = dfs(adj, labels, child);
            for (int i=0; i<26; i++){
                count[i]+=dfsOut[i];
            }
        }

        Character currChar = labels.charAt(node);
        count[currChar-'a']++;
        result[node] = count[currChar-'a'];

        return count;

    }
}
