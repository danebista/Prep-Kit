import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        helper(nums, result, visited, new ArrayList());

        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, boolean[] visited,
            List<Integer> current) {

        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            current.add(nums[i]);
            helper(nums, result, visited, current);
            visited[i] = false;
            current.remove(Integer.valueOf(nums[i]));
        }
    }
}
