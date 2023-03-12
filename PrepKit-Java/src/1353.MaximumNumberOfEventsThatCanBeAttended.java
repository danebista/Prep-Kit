public class MaximumNumberOfEventsThatCanBeAttended {
    class Solution {
        public int maxEvents(int[][] A) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
            int i = 0, res = 0, n = A.length;
            for (int d = 1; d <= 100000; ++d) {
                while (!pq.isEmpty() && pq.peek() < d)
                    pq.poll();
                while (i < n && A[i][0] == d)
                    pq.offer(A[i++][1]);
                if (!pq.isEmpty()) {
                    pq.poll();
                    ++res;
                }
            }
            return res;
        }
    }
}

class Solution {

    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> allEvents = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    
        PriorityQueue<int[]> curEvents = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    
        for (var event : events) {
            allEvents.add(event);
        }
        //curEvents.add(allEvents.poll());
        int curTime = allEvents.peek()[0];
        int count = 0;
        while (allEvents.size() > 0 || curEvents.size() > 0) {
            while (allEvents.size() > 0 && allEvents.peek()[0] <= curTime && allEvents.peek()[1] >= curTime) {
                curEvents.add(allEvents.poll());
            }
    
            if (curEvents.size() > 0) {
                var next = curEvents.poll();
                if (next[1] >= curTime) {
                    count++;
                    curTime++;
                }
            } else {
                if (allEvents.size() > 0) {
                    curTime = allEvents.peek()[0];
                }
            }
        }
        return count;
    }
    }
    
    
    
    