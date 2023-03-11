/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
       if (head==null)return null;
       return helper(head);
    }

    public TreeNode helper(ListNode curr){
        if (curr == null) return null;
        if (curr.next==null) return new TreeNode(curr.val);
        ListNode slow = curr;
        ListNode fast = curr;
        ListNode prev=curr;
        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode mid = slow;
        prev.next=null;

        TreeNode root = new TreeNode(mid.val);
       
        root.left = helper(curr);
        root.right = helper(mid.next);
        
        return root;
    }
}