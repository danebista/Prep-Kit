class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Node[] results = new Node[nums1.length];

        for (int i=0; i<nums1.length; i++){
            results[i] = new Node(nums1[i], nums2[i]);
        }
        Arrays.sort(results, (a,b)->(b.number-a.number));
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.val-b.val)); 
        long sum=0;
        long min=Long.MAX_VALUE;
        long finals = 0;
        for (int i=0; i<k; i++){
            sum+=results[i].val;
            min = Math.min(min, results[i].number);
            pq.offer(results[i]);
        }
        finals = min*sum;
        for (int i=k; i< results.length; i++){
            if (pq.peek().val< results[i].val){
                Node curr = pq.poll();
                sum-=curr.val;
                sum+=results[i].val;
                min = results[i].number;
                pq.offer(results[i]);
            }
            finals = Math.max(finals, min* sum);
        }

        return finals;
    }


    class Node{
        int val;
        int number;
        Node(int val, int number){
            this.val = val;
            this.number = number;
        }
    }
}
