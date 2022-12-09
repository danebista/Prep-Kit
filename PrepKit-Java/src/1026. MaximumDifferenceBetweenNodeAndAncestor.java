class Solution {
    public int maxAncestorDiff(TreeNode root) {

        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);
        return Math.max(left, right);
    }
}