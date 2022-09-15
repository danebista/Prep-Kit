
import java.util.*;

public class GraphReachNode {

    static class Graph {
        public int noOfEdges;
        LinkedList<Integer>[] linkedListadj;

        Graph(int noOfEdges) {
            this.noOfEdges = noOfEdges;
            this.linkedListadj = new LinkedList[noOfEdges];

            for (int i = 0; i < noOfEdges; i++) {
                linkedListadj[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int vertex, int edge) {
            linkedListadj[vertex].add(edge);
        }

    }

    public static void main(String[] args) {
        int edge = 6;
        Graph g = new Graph(edge);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(4, 3);
        g.addEdge(5, 2);

        System.out.println(isReachable(g, 1, 6));

    }

    public static boolean isReachable(Graph g, int source, int destination) {
        int noOfEdges = g.noOfEdges;
        boolean[] visited = new boolean[noOfEdges];
        visited[source] = true;

        Queue<Integer> queue = new LinkedList();
        queue.offer(source);

        while (queue.size() != 0) {
            Integer curr = queue.poll();
            LinkedList<Integer> currList = g.linkedListadj[curr];
            Iterator i = currList.listIterator();
            while (i.hasNext()) {
                int n = (Integer) i.next();
                if (n == destination)
                    return true;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }

        return false;

    }

}
