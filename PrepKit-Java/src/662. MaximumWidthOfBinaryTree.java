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
class Pair {
    int val;
    TreeNode node;

    Pair(int val, TreeNode node) {
        this.val = val;
        this.node = node;
    }

}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        int maxi = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().val;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                int index = curr.val - min;
                if (i == 0)
                    first = index;
                if (i == size - 1)
                    last = index;
                if (curr.node.left != null)
                    queue.offer(new Pair(index * 2 + 1, curr.node.left));
                if (curr.node.right != null)
                    queue.offer(new Pair(index * 2 + 2, curr.node.right));
            }
            maxi = Math.max(maxi, last - first + 1);
        }

        return maxi;
    }
}
