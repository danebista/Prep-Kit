class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            if (depth != d - 1){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            } else {
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    TreeNode newLeft = new TreeNode(v);
                    newLeft.left = node.left;
                    node.left = newLeft;
                    TreeNode newRight = new TreeNode(v);
                    newRight.right = node.right;
                    node.right = newRight;
                }
                break;
            }
        }
        return root;
    }
}
