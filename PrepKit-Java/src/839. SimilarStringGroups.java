class Solution {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf= new UnionFind(strs.length);

        for (int i=0; i< strs.length-1; i++){
            for (int j=i+1; j< strs.length; j++){
                if (isSimilar(strs[i],strs[j])){
                    uf.union(i,j);
                }
            }
        }
        int ans=0;
        for (int i=0; i< uf.parent.length; i++){
            if (uf.parent[i]==i) ans++;
        }

        return ans;
    }

    public boolean isSimilar(String a, String b){
        int count=0;
        for (int i=0; i< a.length(); i++){
            if (a.charAt(i)!=b.charAt(i)) count++;
        }
        return count<=2;
    }
}

class UnionFind{
    int[] rank;
    int[] parent;

    UnionFind(int size){
        rank = new int[size];
        parent = new int[size];
        for (int i=0; i< size; i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int findParent(int n){
        if (n==parent[n]) return n;
        parent[n] = findParent(parent[n]);
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
            rank[py]++;
            parent[px] = py;
        }
    }
}
