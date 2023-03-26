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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer>list =  new ArrayList<>();
        
            for (int i=0; i< size; i++){
                TreeNode val = queue.poll();
                 list.add(val.val);
               
                if (val.left!=null){
                    queue.offer(val.left);
                }
                if (val.right!=null){
                    queue.offer(val.right);
                }

            }
            
            int[] sorted = new int[list.size()];
            for(int i=0; i<sorted.length; i++) sorted[i] = list.get(i);
            Arrays.sort(sorted);
            Map<Integer, Integer> ind = new HashMap<>();
            for(int i=0; i<list.size(); i++) ind.put(list.get(i), i);
        
            for(int i=0; i<list.size(); i++) {
                if(list.get(i) != sorted[i]) {
                    count++;
                    ind.put(list.get(i), ind.get(sorted[i]));
                    list.set(ind.get(sorted[i]), list.get(i));
                }
            }
        }
        return count;
    }

    class Pair{
        int val; 
        int index;
        Pair(int val, int index){
            this.val=val;
            this.index = index;
        }
    }
}
