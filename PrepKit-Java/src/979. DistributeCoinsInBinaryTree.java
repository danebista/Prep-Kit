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
    int coins;
    public int distributeCoins(TreeNode root) {
        coins=0;
        helper(root);
        return coins;
    }

    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        coins+=Math.abs(left)+Math.abs(right);//Coins needed + excess coins
        return left+right+root.val-1;//-1 because one coin got used up in my step;
    }
}
