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
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        int value1 = 0;
        int value2 = 0;
        if (root1 == null && root2 == null)
            return null;

        if (root1 != null)
            value1 = root1.val;
        if (root2 != null)
            value2 = root2.val;
        TreeNode root = new TreeNode(value1 + value2);
        TreeNode left1 = root1 == null ? null : root1.left;
        TreeNode left2 = root2 == null ? null : root2.left;
        TreeNode right1 = root1 == null ? null : root1.right;
        TreeNode right2 = root2 == null ? null : root2.right;
        root.left = mergeTrees(left1, left2);
        root.right = mergeTrees(right1, right2);
        return root;
    }
}
