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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode end = reverse(slow);
        int max = 0;
        while (end!=null){
            max = Math.max(max, end.val+head.val);
            end = end.next;
            head = head.next;
        }
        return max;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
