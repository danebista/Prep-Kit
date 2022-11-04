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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null)
            return result;
        helper(result, root, 0);
        return result;
    }

    public void helper(List<Integer> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level)
            result.add(root.val);

        if (root.right != null) {
            helper(result, root.right, level + 1);
        }
        if (root.left != null) {
            helper(result, root.left, level + 1);
        }
    }
}
