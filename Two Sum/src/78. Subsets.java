import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        helper(nums, result, new ArrayList(), 0);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result,
            List<Integer> current, int index) {

        if (index >= nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        helper(nums, result, current, index + 1);
        current.remove(Integer.valueOf(nums[index]));
        helper(nums, result, current, index + 1);
    }
}
