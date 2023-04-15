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
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null)return true;
        if (root1==null) return false;
        if (root2==null) return false;

        boolean l1= flipEquiv(root1.left, root2.right);
        boolean l2 = flipEquiv(root1.right, root2.left);
        boolean l3 = flipEquiv(root1.left, root2.left);
        boolean l4 = flipEquiv(root1.right, root2.right);

        if (root1.val == root2.val && (l1 && l2)) return true;
        if (root1.val==root2.val && (l3 && l4)) return true;

        return false;
    }
}