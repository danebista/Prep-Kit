class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> hashmapR = new HashMap<>();
        HashMap<Integer, List<Integer>> hashmapB= new HashMap<>();
        for (int[] r: redEdges){
            if (!hashmapR.containsKey(r[0])){
                List<Integer> result = new ArrayList<>();
                hashmapR.put(r[0], result);
            }
            hashmapR.get(r[0]).add(r[1]);
        }

        for (int[] b: blueEdges){
            if (!hashmapB.containsKey(b[0])){
                List<Integer> result = new ArrayList<>();
                hashmapB.put(b[0], result);
            }
            hashmapB.get(b[0]).add(b[1]);
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        queue.offer(new Pair(0,null));
        int steps=0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++){
            
                Pair curr = queue.poll();
                if (answer[curr.node]==-1){
                    answer[curr.node]=steps;
                }
                if (curr.color == null || !curr.color.equals("Red")){
                    System.out.println(curr.node);
                    if (hashmapR.containsKey(curr.node)){
                        for (Integer nei: hashmapR.get(curr.node)){
                            if (visited.contains(nei+"Red")) continue;
                            queue.offer(new Pair(nei, "Red"));
                            visited.add(nei+"Red");
                        }
                    }
                }
    
                if (curr.color==null || !curr.color.equals("Blue")){
                    System.out.println(curr.node);
                  
                    if (!hashmapB.containsKey(curr.node)) continue;
                    for (Integer nei: hashmapB.get(curr.node)){
                        if (visited.contains(nei+"Blue")) continue;
                        queue.offer(new Pair(nei, "Blue"));
                        visited.add(nei+"Blue");
                    }
                }
            }

            steps++;
        }


        return answer;
    }

    class Pair{
        int node;
        String color;
        Pair(int node, String color){
            this.node = node;
            this.color = color;
        }
    }
}