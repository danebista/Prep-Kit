public class MeetingRoomII {
    /**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        if (intervals.size()==0) return 0;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)-> a.end-b.end);
        pq.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i++){
            Interval database = pq.poll();
            Interval current = intervals.get(i);
            if (database.end <= current.start){
                database.end=current.end;
            }
            else{
                pq.offer(current);
            }
            pq.offer(database);
        }

        return pq.size();
    }
}
}
