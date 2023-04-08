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
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null)return new int[]{};
        max = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        helper(root, hashmap);
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> val: hashmap.entrySet()){
            if (val.getValue() == max){
                result.add(val.getKey());
            }   
        }

        int[]res = new int[result.size()];
        int index=0;
        for (int val: result){
            res[index++] = val;
            
        }
        return res;
    }

    public int helper(TreeNode root, HashMap<Integer, Integer> hashmap){
        if (root==null) return 0;
        int left = helper(root.left, hashmap);
        int right = helper(root.right, hashmap);
        int key = root.val+left+right;
       
        hashmap.put(key, hashmap.getOrDefault(key,0)+1);
        max = Math.max(max, hashmap.get(key));


        return root.val+left+right;
    }
}
