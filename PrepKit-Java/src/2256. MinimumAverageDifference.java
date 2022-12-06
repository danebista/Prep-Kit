class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sumTogether = 0;
        long sumAn = 0;
        long total = Long.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            sumTogether += nums[i];
        for (int i = 0; i < nums.length; i++) {
            sumAn += nums[i];
            sumTogether -= nums[i];
            long difference1 = sumAn / (i + 1);
            long difference2 = (i == nums.length - 1) ? 0 : sumTogether / (nums.length - i - 1);
            if (Math.abs(difference1 - difference2) < total) {
                total = Math.abs(difference1 - difference2);
                index = i;
            }
        }
        return index;
    }
}
