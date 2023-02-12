class Solution {
    long answer;
    public long minimumFuelCost(int[][] roads, int seats) {
        answer = 0;
    
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int[] road: roads){
            if (!hashmap.containsKey(road[0])){
                hashmap.put(road[0], new ArrayList<>());
            }

            if (!hashmap.containsKey(road[1])){
                hashmap.put(road[1], new ArrayList<>());
            }
            hashmap.get(road[0]).add(road[1]);
            hashmap.get(road[1]).add(road[0]);
        }
        long [] val = new long[roads.length+1];
        
        dfs(0, hashmap, seats, -1, val);
        Queue<Integer> queue = new LinkedList<>();
        long answer = 0;
        HashSet<Integer> hashset = new HashSet<>();
        queue.add(0);
        hashset.add(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++){
                Integer value = queue.poll();
                if (!hashmap.containsKey(value)){
                    continue;
                }

                for(Integer nei: hashmap.get(value)){
                    if (!hashset.contains(nei)){
                    
                        hashset.add(nei);
                        answer += (val[nei] + seats - 1) / seats;
                        queue.offer(nei);
                    }
                }
            }
        }

        return answer;

    }

    public long dfs(int node, HashMap<Integer, List<Integer>> hashmap, int seats, int parent, long[] val){
        long cnt = 1;
        if (!hashmap.containsKey(node)){
          val[node] =cnt;
          return cnt;  
        }

        for (Integer r:hashmap.get(node)){
            if (r!=parent){
                cnt+=dfs(r, hashmap, seats,node, val);
            }
        }
        val[node] = cnt;
        return cnt;
    }
}
