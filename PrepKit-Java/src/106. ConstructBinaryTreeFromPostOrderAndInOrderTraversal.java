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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashmap = new HashMap();

        for (int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i], i);
        }

        return helper(postorder, hashmap, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postOrder, Map<Integer, Integer> hashmap, int postStart, int postEnd,
            int inStart, int inEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int index = hashmap.get(postOrder[postEnd]);
        int diff = inEnd - index;
        root.right = helper(postOrder, hashmap, postEnd - diff, postEnd - 1, index + 1, inEnd);
        root.left = helper(postOrder, hashmap, postStart, postEnd - diff - 1, inStart, index - 1);

        return root;

    }
}
