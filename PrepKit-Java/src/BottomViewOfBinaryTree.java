class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> treemap = new TreeMap<>();

        if (root == null)
            return result;
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int currVal = temp.val;
            Node currTree = temp.node;
            treemap.put(currVal, currTree.data);

            if (currTree.left != null) {
                queue.offer(new Pair(currVal - 1, currTree.left));
            }

            if (currTree.right != null) {
                queue.offer(new Pair(currVal + 1, currTree.right));
            }
        }

        for (Integer data : treemap.values()) {
            result.add(data);
        }

        return result;
    }
}
