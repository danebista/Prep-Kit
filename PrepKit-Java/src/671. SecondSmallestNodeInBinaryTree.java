class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        max = root.val;
        min = Integer.MAX_VALUE;
        dfs(root);
        return max == root.val ? -1 : min;
    }
    
    void dfs(TreeNode root){
        if(root.left != null){
            if(root.val != root.left.val) {
                min = Math.min(min, root.left.val);
                max = Math.max(min, root.left.val);
            }
            if(root.val != root.right.val) {
                min = Math.min(min, root.right.val);
                max = Math.max(min, root.right.val);
            }
            dfs(root.left);
            dfs(root.right);
        }
    }
}
