/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    TreeNode first=null;
    TreeNode last=null;
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        helper(root);
        System.out.println(first.val);
        last.right=first;
        first.left=last;
        return first;
    }

    public void helper(TreeNode root){
        if (root==null) return;

        helper(root.left);
       
        if (first==null){first = root;}
        
        if (last!=null){
            
            last.right=root;
            root.left=last;
        }
        
        last=root;
        helper(root.right);
    }
}
