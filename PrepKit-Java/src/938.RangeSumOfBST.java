class Solution {
    int total;
    public int rangeSumBST(TreeNode root, int low, int high) {
        total=0;
        helper(root, low, high);
        return total;
    }
    public void helper(TreeNode curr, int low, int high){
        if (curr==null) return;
        if (curr.val>=low && curr.val<=high) {
          total+=curr.val;
          helper(curr.left, low, curr.val);
          helper(curr.right, curr.val, high);
        }
        else if(curr.val>high){
            helper(curr.left, low, high);
        }
        else {
            helper(curr.right, low, high);
        }

    }
}