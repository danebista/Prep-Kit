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
    int minimum;
    Integer prev;
    public int getMinimumDifference(TreeNode root) {
        minimum = Integer.MAX_VALUE;
        prev=null;
        helper(root);
        return minimum;
    }
    public void helper(TreeNode root){
        if (root==null) return ;
        helper(root.left);
        if (prev!=null){
             minimum= Math.min(root.val-prev, minimum);
        }
        prev=root.val;
       
        helper(root.right);
    }
}
