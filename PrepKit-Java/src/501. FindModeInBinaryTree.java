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
    int max = -1;
    int prev = -1;
    int count = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        List<Integer> result = new ArrayList();

        helper(root, result);
        if (result.size() == 0) {
            int[] res = new int[1];
            res[0] = 0;
            return res;
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        helper(root.left, result);
        if (prev != -1) {
            if (root.val == prev) {
                count++;
            } else {
                count = 0;
            }
        }
        if (count > max) {
            max = count;
            result.clear();
            result.add(root.val);
        } else if (count == max) {
            result.add(root.val);
        }

        prev = root.val;

        helper(root.right, result);

    }

}
