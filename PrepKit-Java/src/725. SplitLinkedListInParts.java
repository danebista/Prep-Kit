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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode counter = head;
        ListNode[]result;
        
        while (counter!=null){
            count+=1;
            counter= counter.next;
        }

        int remaining = 0;
        
        result = new ListNode[k];

        remaining =  k>count?0: count%k;
        int i=0;
        int cou = count/k;
        
        while (i<k){
            int c = 1;
            if (cou !=0) c+=cou-1;
            if (remaining!=0){
                c+=1;
                remaining-=1;
            }
            if (head!=null){
                result[i]=head;
                c-=1;
            }
            while (c!=0&& head!=null){
                head = head.next;
                c-=1;
                if (head==null) break;
            }
            i+=1;
            if(head!=null){ // slicing the rest
        		ListNode temp=head.next;
        		head.next=null;
        		head=temp;
        	}
        }

        return result;

        
    }
}
