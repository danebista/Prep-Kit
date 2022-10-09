class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };

        int startIndex = searchRangeStart(nums, target);
        int endIndex = searchRangeEnd(nums, target);
        return new int[] { startIndex, endIndex };
    }

    public int searchRangeStart(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return index;
    }

    public int searchRangeEnd(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return index;
    }
}
