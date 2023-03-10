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
    int count =0;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        ListNode temp=head;

        while (temp!=null){
            temp = temp.next;
            count++;
        }

    }
    
    public int getRandom() {
        if (head==null) return 0;

        int random =(int) ((Math.random()*(count))+1);

        ListNode temp = head;
        int val = 1;
        
        while (val!=random){
            temp = temp.next;
            val++;
        }

        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
