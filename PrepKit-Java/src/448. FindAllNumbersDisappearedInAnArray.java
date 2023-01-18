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

//0(1) space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            int value = Math.abs(nums[index]);
            nums[index]=-1*value;
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]>0) result.add(i+1);
        }
        return result;
    }
}