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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashset = new HashSet();
        
        return helper(root, k, hashset);
    }
    
    public boolean helper(TreeNode root, int k, HashSet<Integer> hashset){
        if (root == null) return false;
        if (hashset.contains(k-root.val)) return true;
        hashset.add(root.val);
        return helper(root.left, k, hashset) || helper(root.right, k, hashset);
    }
    