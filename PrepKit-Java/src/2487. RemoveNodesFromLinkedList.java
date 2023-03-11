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
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newVal = new ListNode(Integer.MAX_VALUE, head);
        stack.push(newVal);
        
        while (head!=null){
            while(!stack.isEmpty() && stack.peek().val< head.val){
                stack.pop();
            }
            System.out.println(head.val);
            stack.peek().next = head;
            stack.push(head);
            head=head.next;
        
        }
        return newVal.next;
    }
}
