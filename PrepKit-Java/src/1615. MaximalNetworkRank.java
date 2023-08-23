class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int edges[] = new int[n];
        boolean exists[][] = new boolean[n][n];
        for(int i=0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            edges[a]++;
            edges[b]++;
            exists[a][b] = true;
            exists[b][a] = true;
        }
        int maxRank = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank = edges[i] + edges[j];
                if(exists[i][j]){
                    rank--;
                }
                maxRank = Math.max(maxRank,rank);
            }
        }
        return maxRank;
    }
}
