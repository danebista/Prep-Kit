class DisJoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJoint(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(1);
        }
    }

    public int findParent(int n) {
        if (n == parent.get(n))
            return n;
        int par = findParent(parent.get(n));
        parent.set(n, par); // Path Compression
        return parent.get(n);
    }

    public void unionByRank(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);
        int ur = rank.get(u);
        int vr = rank.get(v);

        if (ur < vr) {
            parent.set(up, vp);
        } else if (vr > ur) {
            parent.set(up, vp);
        } else {
            parent.set(vp, up);
            rank.set(up, rank.get(up) + 1);
        }
    }
}

class Solution {

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        HashSet<Integer> hashset = new HashSet();
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisJoint obj = new DisJoint(maxRow + maxCol + 1);

        for (int[] stone : stones) {
            int u = stone[0];
            int v = stone[1] + 1 + maxRow;
            hashset.add(u);
            hashset.add(v);
            obj.unionByRank(u, v);
        }
        int count = 0;
        for (Integer val : hashset) {
            if (val == obj.findParent(val)) {
                count++;
            }
        }

        return stones.length - count;
    }
}
