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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i], i);
        }

        int preOrderStart = 0;
        int preOrderEnd = preorder.length - 1;
        int inOrderStart = 0;
        int inOrderEnd = inorder.length - 1;

        return helper(preorder, preOrderStart, preOrderEnd, inOrderStart, inOrderEnd, hashmap);
    }

    public TreeNode helper(int[] preOrder, int preStart, int preEnd, int inStart, int inEnd,
            Map<Integer, Integer> hashmap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int index = hashmap.get(preOrder[preStart]);
        int numLeft = index - inStart;
        TreeNode root = new TreeNode(preOrder[preStart]);
        root.left = helper(preOrder, preStart + 1, preStart + numLeft, inStart, index - 1, hashmap);
        root.right = helper(preOrder, preStart + numLeft + 1, preEnd, index + 1, inEnd, hashmap);
        return root;
    }
}
