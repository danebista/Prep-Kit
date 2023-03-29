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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int c=1;
        ListNode list1Saver=list1;
        while (list1!=null && c<a){
          list1=list1.next;
          c++;
        }
        ListNode curr = list1;

        while (list1!=null && c<=b+1){
            list1=list1.next;
            c++;
        }

        ListNode tail = list1;
        curr.next=list2;
        
        while (list2.next!=null){
            list2=list2.next;
        }
        list2.next = tail;

        return list1Saver;
    }
}
