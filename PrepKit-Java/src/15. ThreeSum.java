import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            int target = 0 - nums[i];

            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    result.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
}
