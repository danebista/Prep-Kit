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
    Map<Integer, Integer> postMap = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;
        for(int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }
        
        return build(0, length - 1, 0, length - 1, pre);
    }
    
    public TreeNode build(int preStart, int preEnd, int postStart, int postEnd, int[]pre){
        if (preEnd< preStart || postEnd<postStart)return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart+1<=preEnd){
            int index= postMap.get(pre[preStart+1]);
            int diff = index-postStart;
            root.left = build(preStart+1, preStart+diff+1, postStart, postStart+diff, pre);
            root.right = build(preStart+diff+2, preEnd, postStart+diff+1, postEnd-1, pre);
        }
    
        return root;
    }
    
    }
    
    