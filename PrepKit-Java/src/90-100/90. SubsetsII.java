import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList(), 0);

        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, List<Integer> current,
            int index) {
        result.add(new ArrayList(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            helper(nums, result, current, i + 1);
            current.remove(Integer.valueOf(nums[i]));
        }
    }
}
