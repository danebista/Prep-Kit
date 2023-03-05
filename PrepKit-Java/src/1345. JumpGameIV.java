class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (!hashmap.containsKey(arr[i])){
                hashmap.put(arr[i], new ArrayList<>());
            }
            hashmap.get(arr[i]).add(i);
        }

        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[arr.length];
        visited[0]=true;
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            
            for (int i=0; i< size; i++){
                Integer curr = queue.poll();
                if (curr==arr.length-1) return steps;
                List<Integer> vals = hashmap.get(arr[curr]);
                vals.add(curr-1);
                vals.add(curr+1);
                for (int next: vals){
                    if (next<=0 || next>= arr.length) continue;
                    if (!visited[next]){
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
                vals.clear();// please free up memory when not needed
            }
            steps++;
        }

        return steps;
    }
}
