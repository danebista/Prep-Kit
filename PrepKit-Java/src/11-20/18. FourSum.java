
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> values = new LinkedList();
        if (target <= Integer.MIN_VALUE || target >= Integer.MAX_VALUE)
            return values;
        if (nums.length < 4)
            return values;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int low = j + 1;
                int high = nums.length - 1;

                while (low < high) {
                    int value = nums[low] + nums[high] + nums[i] + nums[j];
                    if (target <= Integer.MIN_VALUE || target >= Integer.MAX_VALUE) {
                        List<List<Integer>> result = new LinkedList();
                        return result;
                    }
                    if (value == target) {
                        values.add(Arrays.asList(nums[low], nums[high], nums[i], nums[j]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (value > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return values;
    }
}
