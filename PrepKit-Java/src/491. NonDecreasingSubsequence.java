class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        helper(nums, 0, new ArrayList(), result);
        Set<List<Integer>> set = new HashSet<List<Integer>>(result);
        List<List<Integer>> result2 = new ArrayList<List<Integer>>(set);
        return result2;
    }

    public void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        if (index>=nums.length){
            if (current.size()>1){
                result.add(new ArrayList(current));
            }
            return;
        }

        if (current.size() == 0 || (current.size() >0 && nums[index] >= current.get(current.size()-1))){
             current.add(nums[index]);
             helper(nums, index+1, current, result);
             current.remove(current.size()-1);
        }
        helper(nums, index+1, current, result);
    }
}

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        helper(nums, 0, new ArrayList(), result);
        Set<List<Integer>> set = new HashSet<List<Integer>>(result);
        List<List<Integer>> result2 = new ArrayList<List<Integer>>(set);
        return result2;
    }

    public void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        if (current.size()>1){
            result.add(new ArrayList(current));
        }

        int prev = -10000;
        for (int i=index; i<nums.length; i++){
            if (nums[i]==prev) continue;
            if (current.size() == 0 || (current.size() >0 && nums[i] >= current.get(current.size()-1))){
             current.add(nums[i]);
             helper(nums, i+1, current, result);
             current.remove(current.size()-1);
            }
        }

    }
}