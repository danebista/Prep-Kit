
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = queue.remove();
                current.add(c.val);

                if (c.left != null) {
                    queue.offer(c.left);
                }
                if (c.right != null) {
                    queue.offer(c.right);
                }
            }
            if (!flag)
                Collections.reverse(current);
            result.add(current);
            flag = !flag;
        }

        return result;
    }
}
