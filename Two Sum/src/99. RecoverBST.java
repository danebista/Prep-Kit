
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
