class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i=0; i< accounts.size(); i++){
            List<String> res = accounts.get(i);
            for (int j=1; j< res.size(); j++){
                if (hashmap.containsKey(res.get(j))){
                    uf.union(hashmap.get(res.get(j)), i);
                }
                else {
                    hashmap.put(res.get(j), i);
                }
            }
        }

        HashMap<Integer, HashSet<String>> values = new HashMap<>();

        for (int i=0; i< accounts.size(); i++){
            int index = uf.findParent(i);
            if (!values.containsKey(index)){
                values.put(index, new HashSet<>());
            }
            HashSet<String> curr= values.get(index);
            
            for (int j=1; j< accounts.get(i).size(); j++){
                curr.add(accounts.get(i).get(j));    
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, HashSet<String>> entry: values.entrySet()){
            List<String> single = new ArrayList<String>(entry.getValue());
            Collections.sort(single);
            single.add(0, accounts.get(entry.getKey()).get(0));
            result.add(single);
        }

        return result;

    }


    class UnionFind{
        int[] parent;
        int[]rank;

        UnionFind(int n){
            parent = new int[n];
            for (int i=0; i< parent.length; i++){
                parent[i]=i;
            }
            rank = new int[n];
        }

        public int findParent(int n){
            if (parent[n]==n) return n;
            return parent[n]= findParent(parent[n]);
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
            else{
                rank[px]++;
                parent[py]=px;
            }

        }
    }
}
