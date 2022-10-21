class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashset = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                hashset.remove(nums[i - k - 1]);
            if (!hashset.add(nums[i]))
                return true;
        }

        return false;
    }
}
