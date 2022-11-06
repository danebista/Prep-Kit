class Solution {

    public int numSubseq(int[] nums, int target) {
        int power = (int) 1e9 + 7;
        Arrays.sort(nums);
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % power;
        }
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                ans = (ans + pow[r - l]) % power;
                l++;
            }
        }

        return ans % power;
    }
}