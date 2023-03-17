public boolean isCompleteTree(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flag = true;
    while (!queue.isEmpty()) {
        TreeNode temp = queue.poll();
        if (!flag && (temp.left != null || temp.right != null))
            return false;
        if (temp.left != null && temp.right != null) {
            queue.offer(temp.left);
            queue.offer(temp.right);
        } else if (temp.right != null)
            return false;
        else if (temp.left != null) {
            flag = false;
            queue.offer(temp.left);
        } else
            flag = false;
    }
    return true;
}
