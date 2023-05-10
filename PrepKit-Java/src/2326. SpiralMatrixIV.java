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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int top=0; 
        int bottom = m-1;
        int left=0;
        int right=n-1;
        int[][] matrixResult = new int[m][n];
        for (int[]d: matrixResult){
            Arrays.fill(d, -1);
        }
        while (top<=bottom && left<=right){
            for (int i=left; i<=right; i++){
                matrixResult[top][i] = head.val;
                head=head.next;
                if (head==null) return matrixResult;
            }
            top+=1;

            for (int i=top; i<=bottom; i++){
                matrixResult[i][right]=head.val;
                head=head.next;
                if (head==null) return matrixResult;
            }
            right-=1;

            for (int i=right; i>=left; i--){
                matrixResult[bottom][i]=head.val;
                head=head.next;
                if (head==null) return matrixResult;
            }
            bottom-=1;
            for (int i=bottom; i>=top; i--){
                matrixResult[i][left]=head.val;
                head=head.next;
                if (head==null) return matrixResult;
            }
            left+=1;
        }

        return matrixResult;
    }
}
