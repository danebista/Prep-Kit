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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rootLeft = new ArrayList();
        List<Integer> rootRight = new ArrayList();
        leftHelper(root1, rootLeft);
        leftHelper(root2, rootRight);
        if (rootLeft.size() != rootRight.size())
            return false;
        for (int i = 0; i < rootLeft.size(); i++) {
            if (rootLeft.get(i) != rootRight.get(i))
                return false;
        }
        return true;
    }

    public void leftHelper(TreeNode root, List<Integer> curr) {
        if (root == null)
            return;
        leftHelper(root.left, curr);
        if (root.left == null && root.right == null) {
            curr.add(root.val);
        }
        leftHelper(root.right, curr);
    }
}
