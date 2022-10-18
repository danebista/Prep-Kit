class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int max = 0;
            for (int j = left; j <= right; j++) {

                max = Math.max(max, j + nums[j]);
            }
            left = right + 1;
            right = max;
            jumps += 1;
        }

        return jumps;
    }
}
