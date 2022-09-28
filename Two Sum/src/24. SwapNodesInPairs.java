
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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode temp = new ListNode();
        ListNode prev = temp;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode p = curr.next.next;
            ListNode q = curr.next;

            q.next = curr;
            curr.next = p;
            prev.next = q;

            prev = curr;
            curr = p;
        }

        return temp.next;

    }
}
