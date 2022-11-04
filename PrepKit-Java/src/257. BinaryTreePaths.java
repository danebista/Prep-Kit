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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (root == null)
            return result;
        helper(root, "", result);
        System.out.println(result.toString());
        return result;
    }

    public void helper(TreeNode root, String curr, List<String> result) {

        if (root.left == null && root.right == null) {
            curr += root.val;
            result.add(curr);
            return;
        }
        curr += root.val + "->";
        if (root.left != null)
            helper(root.left, curr, result);
        if (root.right != null)
            helper(root.right, curr, result);
    }
}
