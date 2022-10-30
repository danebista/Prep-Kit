public /**
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
   int maximum;
   
   public int maxPathSum(TreeNode root) {
       maximum = Integer.MIN_VALUE;
       helper(root);
       return maximum;
   }
   
   public int helper(TreeNode node){
       if (node==null) return 0;
       int left = Math.max(0,helper(node.left));
       int right = Math.max(0, helper(node.right));
       maximum = Math.max(maximum, left+node.val+right);
       
       return Math.max(left, right) + node.val;
   }
}{

}
