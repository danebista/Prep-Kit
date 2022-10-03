class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < (Math.pow(2, nums.length)); i++) {

            List<Integer> current = new ArrayList();
            for (int j = 0; j < nums.length; j++) {
                if ((1 << j & i) != 0) {
                    current.add(nums[j]);
                }
            }
            result.add(current);
        }

        return result;
    }
}
