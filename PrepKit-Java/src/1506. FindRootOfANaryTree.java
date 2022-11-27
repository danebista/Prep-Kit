class Solution {
    public Node findRoot(List<Node> tree) {
        int xor = 0;
        for (Node node : tree) {
            xor ^= node.val;
            List<Node> children = node.children;
            for (Node child : children)
                xor ^= child.val;
        }
        for (Node node : tree) {
            if (node.val == xor)
                return node;
        }
        return null;
    }
}
