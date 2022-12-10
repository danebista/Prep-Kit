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
    int result;

    public int maxAncestorDiff(TreeNode root) {
        result = 0;
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return result;
    }

    public void helper(TreeNode root, int min, int max) {
        if (root == null) {
            result = Math.max(result, max - min);
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        helper(root.left, min, max);
        helper(root.right, min, max);

    }
}