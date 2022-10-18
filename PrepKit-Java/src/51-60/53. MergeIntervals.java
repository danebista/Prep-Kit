class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> output = new ArrayList();
        int[] current = intervals[0];
        for (int[] interval : intervals) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                output.add(current);
                current = interval;
            }
        }
        output.add(current);
        return output.toArray(new int[output.size()][2]);
    }
}
