class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> ts = new TreeSet<>();
        Map<Integer,Integer> numCount = new HashMap<>();


        for (int num : nums) {
            ts.add(num);
            numCount.put(num, 1 + numCount.getOrDefault(num, 0));
        }

        int minAns = Integer.MAX_VALUE;
        int j=0;
        for (int i=0; i<nums.size(); ++i) {
            int num;
            while (j < i+x && j < nums.size()) {
                num = nums.get(j);
                numCount.put(num, numCount.get(num) - 1);
                if (numCount.get(num) == 0) {
                    ts.remove(num);
                }
                ++j;
            }
            num = nums.get(i);
            Integer ceil = ts.ceiling(num);
            Integer floor = ts.floor(num);
            if(ceil != null) {
                minAns = Math.min(minAns, Math.abs(ceil - num));
            }
            if(floor != null) {
                minAns = Math.min(minAns, Math.abs(floor - num));
            }
        }

        return minAns;

    }
}