class Solution {
    public int[] findErrorNums(int[] nums) {
        int result = 1;
        for (int i = 2; i <= nums.length; i++) {
            result = result ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        int bitmask = result & -result;

        int x = 0;
        int y = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bitmask) != 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((i & bitmask) != 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) {
                results[0] = x;
                results[1] = y;
                break;
            } else if (i == nums.length - 1) {
                results[0] = y;
                results[1] = x;
            }
        }

        return results;

    }
}
