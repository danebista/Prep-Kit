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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> hashmap = new HashMap<>();
        Set<Integer> hashset = new HashSet<>();

        for (int []des: descriptions){
            
            if (!hashmap.containsKey(des[0])){
                TreeNode newVal = new TreeNode(des[0]);
                hashmap.put(des[0], newVal);
                hashset.add(des[0]);
            }
           
            TreeNode parent = hashmap.get(des[0]);

            if (!hashmap.containsKey(des[1])){
                TreeNode curr = new TreeNode(des[1]);
                hashmap.put(des[1], curr);
            }

            if (hashset.contains(des[1])){
                hashset.remove(des[1]);
            }

            TreeNode child = hashmap.get(des[1]);
            
            if (des[2]==1){
                parent.left = child;
            }
            else {
                parent.right = child;
            }
        }
        
        for (int val: hashset){
            return hashmap.get(val);
        }

        return new TreeNode();
    }
}
