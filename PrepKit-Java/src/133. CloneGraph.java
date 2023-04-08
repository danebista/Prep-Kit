/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null)return null;
        HashMap<Integer, Node> hashmap = new HashMap<>();
        return helper(node, hashmap);
    }

    public Node helper(Node node, HashMap<Integer, Node> hashmap){
        if (hashmap.containsKey(node.val)) return hashmap.get(node.val);
        Node copy = new Node(node.val);
        hashmap.put(node.val, copy);

        for (Node nei: node.neighbors){
            copy.neighbors.add(helper(nei, hashmap));
        }

        return copy;

    }
}

