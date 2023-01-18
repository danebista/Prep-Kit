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
class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode rootIndex;
    TreeNode curr;
    Queue<TreeNode> insertionPosition;
    boolean isFirstInsertionSet;
    public CBTInserter(TreeNode root) {
        queue = new LinkedList<TreeNode>();
        insertionPosition = new LinkedList<TreeNode>();
        rootIndex = root;
        curr = null;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (!isFirstInsertionSet && (temp.left==null || temp.right==null)){
                isFirstInsertionSet = true;
                curr= temp;
            }
            if (temp.left!=null){
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                queue.offer(temp.right);
            }
            if (isFirstInsertionSet){
                insertionPosition.offer(temp);
            }
        }
    }
    
    public int insert(int val) {
        if (curr.left==null){
            TreeNode newNode = new TreeNode(val);
            curr.left = newNode;
            insertionPosition.offer(newNode);
            return curr.val;
        }
        else if (curr.right==null){
            TreeNode newNode = new TreeNode(val);
            curr.right = newNode;
            insertionPosition.offer(newNode);
            
            return curr.val;
        }
        else {
            curr = insertionPosition.poll();
            return insert(val);
        }
    }
    
    public TreeNode get_root() {
        return rootIndex;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

