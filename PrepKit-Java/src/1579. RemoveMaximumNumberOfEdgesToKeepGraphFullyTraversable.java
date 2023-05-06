class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b)->b[0]-a[0]);
        int BobReachable = n;
        int AliceReachable=n;
        int BobRepeats=0;
        int AliceRepeats=0;
        int CommonRepeats=0;
        UnionFind uf = new UnionFind(n);
        
        for (int i=0; i< edges.length; i++){
            if (edges[i][0]==3){
                boolean val1 = uf.unionAlice(edges[i][1], edges[i][2]);
                boolean val2 = uf.unionBob(edges[i][1], edges[i][2]);
                if (val1 && val2) {
                    CommonRepeats++;
                }
                else {
                    if (val1) AliceRepeats++;
                    else AliceReachable--;

                    if (val2) BobRepeats++;
                    else BobReachable--;
                }
            }
            else if (edges[i][0]==2){
                boolean val2 = uf.unionBob(edges[i][1], edges[i][2]);
                if (val2) BobRepeats++;
                else BobReachable--;
            }

            else if (edges[i][0]==1){
                boolean val1 = uf.unionAlice(edges[i][1], edges[i][2]);
                if (val1) AliceRepeats++;
                else AliceReachable--;
            }
        }
        if (AliceReachable>1 || BobReachable>1) return -1;
        
        return AliceRepeats + BobRepeats + CommonRepeats;
    }
}

class UnionFind{
    int[] parentAlice;
    int[] parentBob;
    int[] rankAlice;
    int[] rankBob;

    UnionFind(int n){
       parentAlice = new int[n+1];
       parentBob = new int[n+1];
       rankAlice = new int[n+1];
       rankBob = new int[n+1];

       for (int i=0; i< parentAlice.length; i++){
           parentAlice[i]=i;
           parentBob[i]=i;
           rankAlice[i]=1;
           rankBob[i]=1;
       }
    }

    public int findParentAlice(int i){
        if (i==parentAlice[i]) return i;
        parentAlice[i] = findParentAlice(parentAlice[i]);
        
        return parentAlice[i];
    }

    public int findParentBob(int i){
        if (i==parentBob[i]) return i;
        parentBob[i] = findParentBob(parentBob[i]);
        
        return parentBob[i];
    }

    public boolean unionAlice(int i, int j){
        int px = findParentAlice(i);
        int py = findParentAlice(j);

        if (px==py) return true;

        if (rankAlice[px]< rankAlice[py]){
            parentAlice[px]=py;
        }
        else if (rankAlice[py]< rankAlice[px]){
            parentAlice[py]=px;
        }
        else {
            parentAlice[px]=py;
            rankAlice[py]++;
        }

        return false;
    }

    public boolean unionBob(int i, int j){
        int px = findParentBob(i);
        int py = findParentBob(j);

        if (px==py) return true;

        if (rankBob[px]< rankBob[py]){
            parentBob[px]=py;
        }
        else if (rankBob[py]< rankBob[px]){
            parentBob[py]=px;
        }
        else {
            parentBob[px]=py;
            rankBob[py]++;
        }

        return false;
    }

}
