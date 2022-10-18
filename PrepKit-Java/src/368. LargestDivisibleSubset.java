// Uses the concept of LIS

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] hashset = new int[nums.length];
        int[] dp = new int[nums.length];
        int maxi = 0;
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < hashset.length; i++) {
            hashset[i] = i;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0)
                    continue;
                if ((1 + dp[j]) < dp[i])
                    continue;
                dp[i] = 1 + dp[j];
                hashset[i] = j;
                if (dp[i] < maxi)
                    continue;
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList();
        result.add(nums[lastIndex]);
        while (hashset[lastIndex] != lastIndex) {
            lastIndex = hashset[lastIndex];
            result.add(nums[lastIndex]);
        }

        return result;
    }
}
