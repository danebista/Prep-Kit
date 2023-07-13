class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if (n<=0) return result;
        if (n==1){
            result.add(0);
            return result;
        }
        for (int i=0; i<n; i++){
            hashmap.put(i, new ArrayList<>());
        }
        int[] inDegrees = new int[n];

        for (int[]edge: edges){
            hashmap.get(edge[0]).add(edge[1]);
            hashmap.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i< inDegrees.length; i++){
            if (inDegrees[i] == 1){
                queue.offer(i);
            }
        }

        while (n>2){
            int size=queue.size();
            n = n-size;
            for (int i=0;i<size; i++){
                Integer val = queue.poll();
                for (int dit: hashmap.get(val)){
                    inDegrees[dit]--;
                    if (inDegrees[dit]==1){
                        queue.offer(dit);
                    }
                }
            }
        }

        result.addAll(queue);

        return result;
    }
}
