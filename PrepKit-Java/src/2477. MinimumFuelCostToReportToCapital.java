class Solution {
    long answer;
    public long minimumFuelCost(int[][] roads, int seats) {
        answer = 0;
        HashSet<Integer> visited = new HashSet<>();
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
        
        dfs(0, hashmap, seats, visited);

        return answer;

    }

    public long dfs(int node, HashMap<Integer, List<Integer>> hashmap, int seats, HashSet<Integer> visited){
        long cnt = 1;
        visited.add(node);
        if (!hashmap.containsKey(node)) return cnt;
        for (Integer r:hashmap.get(node)){
            if (!visited.contains(r)){
                cnt+=dfs(r, hashmap, seats, visited);
            }
        }
        if (node !=0){
             if (cnt% seats==0){
                 answer+= cnt/seats;
             }
             else{
                 answer+=1+cnt/seats;
             }
        }

        return cnt;
    }
}
