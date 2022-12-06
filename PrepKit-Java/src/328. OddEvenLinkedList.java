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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        if (head==null) return null; 
        ListNode start = odd;
        ListNode even = new ListNode();
        ListNode temp = head;
   
        while (temp!=null){
            odd.next = new ListNode(temp.val);
            odd=odd.next;
            if (temp.next!=null){
               temp=temp.next.next;
            }
            else{
                break;
            }
        }
        if (head.next==null) return odd;
        temp = head.next;
        ListNode evenStart = even;
        while (temp!=null){
            even.next = new ListNode(temp.val);
            even=even.next;
            if (temp.next!=null){
               temp=temp.next.next;
            }
            else{
                break;
            }
        }
        odd.next=evenStart.next;
        return start.next;
        
    }
}
