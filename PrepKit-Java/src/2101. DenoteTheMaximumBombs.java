class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i=0; i<bombs.length; i++){
            hashmap.put(i,new ArrayList<>());
            for (int j=0; j< bombs.length; j++){
                if(i==j)continue;
                double dist = Math.sqrt(Math.pow(bombs[j][1]-bombs[i][1],2) +
                                        Math.pow(bombs[j][0]-bombs[i][0],2));
                if ((double)bombs[i][2]>= dist){
                    hashmap.get(i).add(j);
                }
            }
        }
        int m=0;
        for (int i=0; i< bombs.length; i++){
            boolean[] visited = new boolean[bombs.length];
            m = Math.max(m, dfs(bombs, i, visited, hashmap));
        }

        return m;
    }

    public int dfs(int[][]bombs, int node, boolean[] visited, HashMap<Integer, List<Integer>> hashmap){
        if(visited[node])return 0;
        int total=1;
        visited[node]=true;
        for (Integer nei: hashmap.get(node)){
            total+=dfs(bombs, nei, visited, hashmap);
        }

        return total;
    }
}
