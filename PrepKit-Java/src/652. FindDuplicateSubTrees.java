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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        helper(root, hashmap, result);

        return result;
    }
    
    public String helper(TreeNode root, HashMap<String, Integer> hashmap, List<TreeNode> result){
        if (root==null) return "*";

        String left = helper(root.left, hashmap, result);
        String right = helper(root.right, hashmap, result);

        String key  = root.val+ ","+ left+ ","+ right;

        if (hashmap.containsKey(key)){
            if (hashmap.get(key)==1) result.add(root);
        }

        hashmap.put(key, hashmap.getOrDefault(key,0)+1);

        return key;
    }

}
