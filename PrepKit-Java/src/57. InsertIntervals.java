class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList();

        for (int[] interval : intervals) {
            if (newInterval[0] > interval[1]) {
                output.add(interval);
            }

            else if (newInterval[1] < interval[0]) {
                output.add(newInterval);
                newInterval = interval;
            } else if (interval[1] >= newInterval[0]) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        output.add(newInterval);

        return output.toArray(new int[output.size()][2]);
    }
}
