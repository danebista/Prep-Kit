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
    public int maxLevelSum(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int index=0;
        long maximum=Long.MIN_VALUE;
        queue.add(root);
        int level=1;
        while (!queue.isEmpty()){
            
            long val=0;
            int size = queue.size();
            for (int i=0; i< size; i++){
                TreeNode curr= queue.poll();
                val+=curr.val;
                if (curr.left !=null){
                    queue.offer(curr.left);
                }
                if (curr.right !=null){
                    queue.offer(curr.right);
                }
            }
            if (maximum< val){
                maximum=val;
                index=level;
            }
            level++;
        }
        return index;
    }
}