class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            map.putIfAbsent(flight[0], new HashMap<>());
            Map<Integer, Integer> info = map.get(flight[0]);
            info.put(flight[1], flight[2]);
        }
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(K-->=0){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int cur = q.poll();
                Map<Integer, Integer> flight = map.get(cur);
                if(flight!=null){
                    for(Integer nei : flight.keySet()){
                        int c = flight.get(nei);
                        if(cost[nei]>cost[cur] + c){
                            cost[nei] = cost[cur] + c;
                            q.add(nei);
                        }
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE?-1:cost[dst];
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            map.putIfAbsent(flight[0], new HashMap<>());
            Map<Integer, Integer> info = map.get(flight[0]);
            info.put(flight[1], flight[2]);
        }
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while(K-->=0){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] cur = q.poll();
                Map<Integer, Integer> flight = map.get(cur[0]);
                if(flight!=null){
                    for(Integer nei : flight.keySet()){
                        int c = flight.get(nei);
                        if(cost[nei]> cur[1] + c){
                            cost[nei] = cur[1] + c;
                            q.add(new int[]{nei, cost[nei]});
                        }
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE?-1:cost[dst];
    }
}
