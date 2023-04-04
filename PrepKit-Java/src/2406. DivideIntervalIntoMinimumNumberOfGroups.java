class Solution {
    public int minGroups(int[][] intervals) {
       Arrays.sort(intervals, (a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
       pq.offer(intervals[0]);
       for (int i=1; i< intervals.length; i++){
           int[] curr = pq.poll();
           if (intervals[i][0]> curr[1]){
               curr[1] = intervals[i][1];
           }
           else{
               pq.offer(intervals[i]);
           }
           pq.offer(curr);
       }

       return pq.size();
    }
}
