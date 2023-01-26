
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
import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode previous = null;

        while (root != null) {
            if (root.left == null) {
                if (previous != null && previous.val > root.val) {
                    if (first == null) {
                        first = previous;
                    }
                    second = root;
                }
                previous = root;    
                root = root.right;
            } else {
                TreeNode left = root.left;
                while (left.right != null && left.right != root) {
                    left = left.right;
                }

                if (left.right == null) {
                    left.right = root;
                    root = root.left;
                } else {
                    left.right = null;
                    if (previous != null && previous.val > root.val) {
                        if (first == null) {
                            first = previous;
                        }
                        second = root;
                    }
                    previous = root;
                    root = root.right;
                }
            }

        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}


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
    TreeNode first;
    TreeNode middle; 
    TreeNode last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        
        if (first !=null && last == null){
            int temp = first.val;
            first.val =  middle.val;
            middle.val = temp;
        }
        else if (first!=null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        if (prev!=null && prev.val>root.val){
            if (first==null){
                first = prev;
                middle = root;
            }
            else if (first!=null){
                last = root;
            }
        }
        prev=root;
        inorder(root.right);
    }
}