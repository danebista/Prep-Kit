/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BST {
    int minValue;
    int maxValue;
    int maxSize;

    BST(int minValue, int maxValue, int maxSize) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}

class Solution {
    int maximum;

    public int maxSumBST(TreeNode root) {
        maximum = 0;
        helper(root);
        return maximum;
    }

    public BST helper(TreeNode root) {
        if (root == null) {
            return new BST(10000000, -10000000, 0);
        }

        BST left = helper(root.left);
        BST right = helper(root.right);

        if (left.maxValue < root.val && root.val < right.minValue) {
            maximum = Math.max(maximum, root.val + left.maxSize + right.maxSize);
            return new BST(Math.min(left.minValue, root.val), Math.max(right.maxValue, root.val),
                    root.val + left.maxSize + right.maxSize);
        }

        return new BST(-10000000, 10000000, Math.max(left.maxSize, right.maxSize));
    }
}
