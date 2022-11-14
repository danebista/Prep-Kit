/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Point {
    int x, y;
    TreeNode node;

    Point(int x, int y, TreeNode node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        if (root == null)
            return result;

        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(0, 0, root));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treemap = new TreeMap();

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            TreeNode node = temp.node;

            if (!treemap.containsKey(x))
                treemap.put(x, new TreeMap<>());
            if (!treemap.get(x).containsKey(y))
                treemap.get(x).put(y, new PriorityQueue<>());
            treemap.get(x).get(y).add(node.val);

            if (node.left != null) {
                queue.offer(new Point(x - 1, y + 1, node.left));
            }

            if (node.right != null) {
                queue.offer(new Point(x + 1, y + 1, node.right));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> x : treemap.values()) {
            List<Integer> curr = new ArrayList();
            for (PriorityQueue<Integer> vals : x.values()) {
                while (!vals.isEmpty()) {
                    curr.add(vals.poll());
                }
            }
            result.add(curr);
        }

        return result;

    }
}
