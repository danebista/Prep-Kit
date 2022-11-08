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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;
        if (root.val==key){
            return findNewBranch(root);
        }
        TreeNode dummy = root;
        while (root != null){
            if (root.val< key){
                if (root.right!=null && root.right.val==key){
                    root.right = findNewBranch(root.right);
                    break;
                }
                root=root.right;
            }
            else{
                if (root.left!=null && root.left.val==key){
                    root.left=findNewBranch(root.left);
                    break;
                }
                root=root.left;
            }
        }
        return dummy;
        
    }
    
    public TreeNode findNewBranch(TreeNode curr){
        if (curr.left == null)return curr.right;
        if (curr.right == null) return curr.left;
        
        TreeNode temp = curr.right;
        TreeNode prim = curr.left;
        while (prim.right!=null){
            prim = prim.right;
        }
        prim.right = temp;
        
        return curr.left;
    }
}
