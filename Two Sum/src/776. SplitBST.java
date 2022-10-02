public class SplitBST {
    public List<TreeNode> SplitBST(TreeNode root, int target){
        return helper(root);
    }

    public List<TreeNode> helper(TreeNode root, int target){
        if (root == null) return {
            new ArrayList(){
                new TreeNode();
                new TreeNode()
            };
        }

        if (target< root.val){
            List<String> results = helper(root.left, target);
            root.left = results.get(1);
            List<String> cu = new ArrayList();
            cu.add(results.get(0));
            cu.add(root);
            return cu;
        }
        
        List<String> results = helper(root.right, target);
        root.right = results.get(0);
        List<String> cu = new ArrayList();
        cu.add(root);
        cu.add(results.get(1));
        return cu;
    }
}
