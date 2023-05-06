class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a,b)->a[2]-b[2]);
        
        int[][] querz = new int[queries.length][4];
        for (int i=0; i< queries.length; i++){
            querz[i][0]=queries[i][0];
            querz[i][1]=queries[i][1];
            querz[i][2]=queries[i][2];
            querz[i][3]=i;
        }

        Arrays.sort(querz, (a,b)->a[2]-b[2]);
        int i=0;
        UnionFind uf = new UnionFind(n);
        boolean[]ans = new boolean[queries.length];
        int j=0;
        for (int[]query: querz){
           int limit = query[2];
           for (; i<edgeList.length; i++){
               if (edgeList[i][2]>=limit) break;
               uf.union(edgeList[i][0], edgeList[i][1]);
           }
        
           ans[query[3]]= uf.exists(query[0], query[1]);
        }

        return ans;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    
    UnionFind(int n){
        
        parent=new int[n];
        rank = new int[n];
        for (int  i=0; i< n; i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    public boolean exists (int i, int j){
        int px = findParent(i);
        int py = findParent(j);
        return px==py;
    }

    public int findParent(int n){
        if (n==parent[n]) return n;
        parent[n]= findParent(parent[n]);
        return parent[n];
    }
    public void union(int i, int j){
        int px = findParent(i);
        int py = findParent(j);

        if (px==py) return;
        if (rank[px]< rank[py]){
            parent[px]=py;
        }
        else if (rank[py]< rank[px]){
            parent[py]=px;
        }
        else {
            parent[px]=py;
            rank[py]++;
        }
    }
}
