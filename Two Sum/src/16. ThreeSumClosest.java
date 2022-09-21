import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumTarget = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int value = nums[l] + nums[r] + nums[i];

                if (value == target) {
                    return target;
                } else if (value < target) {
                    l++;
                } else {
                    r--;
                }

                if (Math.abs(value - target) < Math.abs(sumTarget - target)) {
                    sumTarget = value;
                }
            }
        }

        return sumTarget;
    }
}
