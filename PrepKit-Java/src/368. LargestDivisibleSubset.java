class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] indexStorer = new int[nums.length];
        int lastIndex = 0;
        int maxVal = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            indexStorer[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && (1 + dp[j]) > dp[i]) {
                    dp[i] = 1 + dp[j];
                    indexStorer[i] = j;
                    if (maxVal < dp[i]) {
                        maxVal = dp[i];
                        lastIndex = i;
                    }
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        results.add(nums[lastIndex]);

        while (indexStorer[lastIndex] != lastIndex) {
            lastIndex = indexStorer[lastIndex];
            results.add(nums[lastIndex]);
        }

        return results;
    }
}