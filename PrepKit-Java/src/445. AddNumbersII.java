    445. Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        System.out.println(l1.val);
        System.out.println(l2.val);
        int sum=0;
        int carry=0;
        ListNode l3 = new ListNode();
        ListNode head = l3;

        while (l1!=null || l2!=null){
            int a1=0;
            int b1=0;
            if (l1!=null){
                a1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                b1 = l2.val;
                l2 = l2.next;
            }
            sum=a1+b1+carry;
            l3.next = new ListNode(sum%10);
            carry=sum/10;
            l3= l3.next;
        }
        if (carry!=0){
            l3.next = new ListNode(carry);
            l3 = l3.next;
        }

        head = head.next;
        ListNode ans = reverse(head);

        return ans;
    }

    public ListNode reverse(ListNode l1){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = l1;

        while (curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}