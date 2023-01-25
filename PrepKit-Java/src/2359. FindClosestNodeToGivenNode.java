class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] node1Distance = new int[edges.length];
        Arrays.fill(node1Distance, -1);
        int[] node2Distance  = new int[edges.length];
        Arrays.fill(node2Distance, -1);

        findHelper(node1, node1Distance, 0, edges);
        findHelper(node2, node2Distance, 0, edges);
        int dist = Integer.MAX_VALUE;
        int result =-1;
        for (int i=0; i<edges.length; i++){
            if (Math.min(node1Distance[i], node2Distance[i])>=0 && Math.max(node1Distance[i], node2Distance[i])< dist){
                dist = Math.max(node1Distance[i], node2Distance[i]);
                result = i;
            }
        }

        return result;
    }

    public void findHelper(int node, int[] nodeDis, int distance, int[] edges){
        
        if (node != -1 && nodeDis[node]== -1){
            
            nodeDis[node] = distance;
            findHelper(edges[node], nodeDis, distance+1, edges);

        }
    }
}
