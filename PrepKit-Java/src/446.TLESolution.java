class Solution {
    int number = 0;

    public int numberOfArithmeticSlices(int[] nums) {
        number = 0;
        helper(0, nums, -1, new ArrayList());
        return number;
    }

    public void helper(int index, int[] nums, int prev, List<Integer> current) {

        if (index >= nums.length) {
            if (current.size() >= 3) {
                number += 1;
                System.out.println(current);
            }
            return;
        }

        if (current.size() == 0) {
            current.add(nums[index]);
            helper(index + 1, nums, nums[index], current);
            current.remove(current.size() - 1);
        }

        else if (current.size() == 1) {
            long value = (long) nums[index] - current.get(current.size() - 1);
            if (value > Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {

                current.add(nums[index]);
                helper(index + 1, nums, (int) value, current);
                current.remove(current.size() - 1);
            }
        } else if ((nums[index] - current.get(current.size() - 1)) == prev) {
            long value = (long) nums[index] - current.get(current.size() - 1);

            if (value > Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
                value = (int) value;
                current.add(nums[index]);
                helper(index + 1, nums, (int) value, current);
                current.remove(current.size() - 1);
            }
        }

        helper(index + 1, nums, prev, current);
    }
}
