import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        combinationalSum(new ArrayList(), candidates, target, 0);
        return result;
    }

    public void combinationalSum(List<Integer> current, int[] candidates, int target, int index) {

        if (target == 0) {
            result.add(new ArrayList(current));
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                combinationalSum(current, candidates, target - candidates[i], i);
                current.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}
