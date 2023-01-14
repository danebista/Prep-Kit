class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> hashset = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            hashset.add(nums[i]);
        }

        for (int i=1; i<=nums.length; i++){
            if (!hashset.contains(i)) result.add(i);
        }
        return result;
    }
}
