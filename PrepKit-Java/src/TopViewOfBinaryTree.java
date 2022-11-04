class Pair {
    int val;
    Node node;

    Pair(int val, Node node) {
        this.val = val;
        this.node = node;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> hashmap = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        if (root == null)
            return result;
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            if (!hashmap.containsKey(temp.val)) {
                hashmap.put(temp.val, temp.node.data);
            }

            if (temp.node.left != null) {
                Pair temps = new Pair(temp.val - 1, temp.node.left);
                queue.offer(temps);
            }

            if (temp.node.right != null) {
                Pair temps = new Pair(temp.val + 1, temp.node.right);
                queue.offer(temps);
            }
        }

        for (Integer value : hashmap.values()) {
            result.add(value);
        }

        return result;
    }
}
