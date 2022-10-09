
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
import java.util.*;

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;
        ListNode l1 = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;
        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    public ListNode reverse(ListNode curr) {
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        ListNode prev = l2;
        while (l1 != null && l2 != null) {

            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            l2.next = l1_next;
            l1 = l1_next;
            prev = l2;
            l2 = l2_next;
        }
        if (l2 != null) {
            prev.next = l2;
        }
    }
}
