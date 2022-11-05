/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        List<Integer> current = new ArrayList<>();
        helper(current, A, B);
        int[] result = new int[current.size()];
        int ind = 0;
        for (Integer i : current) {
            result[ind] = i;
            ind++;
        }
        return result;
    }

    public boolean helper(List<Integer> current, TreeNode A, int B) {
        if (A == null)
            return false;
        current.add(A.val);
        if (A.val == B)
            return true;
        boolean left = helper(current, A.left, B);
        if (left)
            return true;

        boolean right = helper(current, A.right, B);
        if (right)
            return true;
        current.remove(current.size() - 1);
        return false;
    }
}
