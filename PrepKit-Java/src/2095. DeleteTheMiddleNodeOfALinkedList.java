/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowHolder = head;

        if (head == null)
            return head;
        if (head.next == null)
            return head.next;
        while (fast != null && fast.next != null) {
            slowHolder = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        slowHolder.next = slow.next;
        slow.next = null;
        return head;
    }
}
