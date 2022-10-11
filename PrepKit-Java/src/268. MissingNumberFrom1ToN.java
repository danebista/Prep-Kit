class Solution {
    public int missingNumber(int[] nums) {
        int xorRes = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            xorRes ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            xorRes ^= nums[i];
        }

        return xorRes;
    }
}
