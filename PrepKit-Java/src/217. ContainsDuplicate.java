class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!hashset.add(nums[i]))
                return true;
        }
        return false;
    }
}
