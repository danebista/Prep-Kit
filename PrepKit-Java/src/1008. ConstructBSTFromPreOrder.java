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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1];
        return bstFromPreOrder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
    }

    public TreeNode bstFromPreOrder(int[] preorder, int lower, int upper, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] < lower || preorder[index[0]] > upper)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreOrder(preorder, lower, root.val, index);
        root.right = bstFromPreOrder(preorder, root.val, upper, index);
        return root;
    }
}
