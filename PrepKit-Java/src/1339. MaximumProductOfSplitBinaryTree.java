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
    long MOD =(long) 1e9+7;
    long maxResult = 0;
    long totalSum=0;
    public long totalSumTree(TreeNode root){
        if (root==null) return 0;
        long left = totalSumTree(root.left);
        long right = totalSumTree(root.right);
        
        return root.val+left+right;
    }

    public int maxProduct(TreeNode root) {
        totalSum = totalSumTree(root);
        int maxProdFinder = helper(root); 
        return (int)(maxResult%MOD);
    }
    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        long subTreeSum = left+right+root.val;
        long maxRemains = totalSum-subTreeSum;
        long result = (maxRemains * subTreeSum);
        maxResult = Math.max(maxResult, result);
        
        return (int)subTreeSum;
    }

}

