class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            int right = 0;

            if (i > 1) {
                left += prev2;
            }
            if (i > 0) {
                right = prev1;
            }

            curr = Math.max(left, right);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;

    }
}
