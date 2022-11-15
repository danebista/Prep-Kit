class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] numsIndex = new int[3];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i == 0)
                numsIndex[nums[i] % 3] += nums[i];
            else {
                int value1 = numsIndex[0] + nums[i];
                int value2 = numsIndex[1] + nums[i];
                int value3 = numsIndex[2] + nums[i];
                numsIndex[value1 % 3] = Math.max(numsIndex[value1 % 3], value1);
                numsIndex[value2 % 3] = Math.max(numsIndex[value2 % 3], value2);
                numsIndex[value3 % 3] = Math.max(numsIndex[value3 % 3], value3);
            }
        }

        return numsIndex[0];
    }
}
