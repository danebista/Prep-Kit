class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length];
        int[] lid = new int[nums.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lid, 1);
        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j] && lid[i] < lid[j] + 1) {
                    lid[i] = lid[j] + 1;
                }

                if (lis[i] > 1 && lid[i] > 1) {
                    maxi = Math.max(maxi, lis[i] + lid[i] - 1);
                }
            }
        }

        return nums.length - maxi;
    }
}
