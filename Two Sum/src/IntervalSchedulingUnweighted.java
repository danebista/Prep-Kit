import java.util.*;

public class IntervalSchedulingUnweighted {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int initialEnd = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= initialEnd) {
                count++;
                initialEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
