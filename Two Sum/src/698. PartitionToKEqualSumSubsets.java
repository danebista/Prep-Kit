class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;
        return helper(nums, 0, sum / k, k, sum / k, visited);
    }

    public boolean helper(int[] nums, int index, int target, int k, int totalSum, boolean[] visited) {
        if (k == 0)
            return true;
        if (target == 0) {
            return helper(nums, 0, totalSum, k - 1, totalSum, visited);
        }
        for (int i = index; i < nums.length; i++) {

            if (target - nums[i] < 0 || visited[i])
                continue;
            // always try to prune the solution when going through this route
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;

            if (helper(nums, i + 1, target - nums[i], k, totalSum, visited)) {
                return true;
            }
            visited[i] = false;

        }
        return false;
    }
}
