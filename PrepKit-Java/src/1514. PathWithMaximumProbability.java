class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<Pair>> hashmap = new HashMap<>();
        for (int i=0; i<n; i++){
            hashmap.put(i,new ArrayList<>());
        }
        int idx=0;
        for (int[]edge: edges){
            hashmap.get(edge[0]).add(new Pair(edge[1],succProb[idx]));
            hashmap.get(edge[1]).add(new Pair(edge[0],succProb[idx++]));
        }
        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->Double.compare(b.prob,a.prob));
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            if (curr.source==end) return curr.prob;
            visited.add(curr.source);
            for (Pair newPath: hashmap.get(curr.source)){
                if (!visited.contains(newPath.source)){
                    pq.offer(new Pair(newPath.source, curr.prob * newPath.prob));
                }
            }
        }
        return 0.0;
    }

    class Pair{
        double prob;
        int source;

        public Pair(int source, double prob){
            this.prob=prob;
            this.source=source;
        }
    }
}
