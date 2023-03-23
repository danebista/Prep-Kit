class Solution {
    public int minScore(int n, int[][] roads) {
        int[]distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        HashMap<Integer, List<Pair>> hashmap = new HashMap<>();
        
        for (int i=0; i<roads.length; i++){
            int val1 = roads[i][0]-1;
            int val2 = roads[i][1]-1;
            
            if (!hashmap.containsKey(val1)){
                hashmap.put(val1, new ArrayList<Pair>());
            }
            Pair value = new Pair(val2, roads[i][2]);
            hashmap.get(val1).add(value);
            
            if (!hashmap.containsKey(val2)){
                hashmap.put(val2, new ArrayList<Pair>());
            }
            Pair newVal = new Pair(val1, roads[i][2]);
            hashmap.get(val2).add(newVal);
            
        }

        distance[0]=Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.distance-b.distance));
        pq.add(new Pair(0,Integer.MAX_VALUE));

        while (!pq.isEmpty()){
            Pair curr = pq.poll();
         
          


            List<Pair> vals= hashmap.get(curr.target);
          
            for (Pair val: vals){
                if (distance[val.target]>Math.min(val.distance, curr.distance)){
                   
                    val.distance = Math.min(curr.distance, val.distance);
                  
                    pq.offer(val);
                    distance[val.target]=Math.min(val.distance, curr.distance);
                }
            }
        }

        return distance[n-1];

        
    }

    class Pair{
        int target; 
        int distance;
        Pair (int target, int distance){
            this.target= target;
            this.distance= distance;
        }
    }
}