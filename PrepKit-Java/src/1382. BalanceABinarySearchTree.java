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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        helper(values, root);
        return buildTree(values, 0, values.size()-1);
    }

    public void helper(List<Integer> values, TreeNode root){
        if (root==null) return;
        helper(values, root.left);
        values.add(root.val);
        helper(values, root.right);

    }
    public TreeNode buildTree(List<Integer> values, int l, int r){
        if (l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode curr= new TreeNode(values.get(mid));
        curr.left = buildTree(values, l, mid-1);
        curr.right = buildTree(values, mid+1, r);
        return curr;
    }
}
