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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> answers = new ArrayList<>();
        queue.add(root);
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
            answers.add(val);
        }
        
        Collections.sort(answers);
     
        if (k>answers.size()) return -1;
        
        for (int i=answers.size()-1; i>=0; i--){
            k--;
            if (k==0) return answers.get(i);
        }
        return -1;
    }
}