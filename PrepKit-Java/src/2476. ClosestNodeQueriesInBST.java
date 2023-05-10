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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(inorder);
        for (Integer query: queries){
            int index1=-1;
            int index2=-1;
           
            int indexSearch = findIndex(inorder, query);
             if (query ==191){
                System.out.println(indexSearch);
                System.out.println(inorder.get(indexSearch));
                System.out.println(query);
                System.out.println(inorder.get(indexSearch)==query);
            }
            List<Integer> val = new ArrayList<>();
            if (indexSearch>=inorder.size()){
               
                val.add(inorder.get(inorder.size()-1));
                val.add(-1);
                
            }
            else if (inorder.get(indexSearch).equals(query)){
                val.add(query);
                val.add(query);
            }
            else if (indexSearch>0 && inorder.get(indexSearch-1)< query && inorder.get(indexSearch)>query){
                val.add(inorder.get(indexSearch-1));
                val.add(inorder.get(indexSearch));
            }
            else{
                val.add(-1);
                val.add(inorder.get(indexSearch));
            }
            result.add(val);
        }

        return result;
    }

    public int findIndex(List<Integer> inorder, Integer query){
        int index=-1;
        int low = 0;
        int high = inorder.size()-1;
        int val = 0;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (inorder.get(mid)==query) return mid;
            else if (inorder.get(mid)<query){
                low=mid+1;
            }
            else high=mid-1;
        }
        return low;
    }
    public void inorder(TreeNode root, List<Integer> inorder){
        if (root==null) return;

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}
