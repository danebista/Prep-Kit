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

/** Combination Sum using pick and non-pick **/
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        combinationalSum(new ArrayList(), candidates, target, 0);
        return result;
    }

    public void combinationalSum(List<Integer> current, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList(current));
            }
            return;
        }

        if (candidates[index] <= target) {
            current.add(candidates[index]);
            combinationalSum(current, candidates, target - candidates[index], index);
            current.remove(new Integer(candidates[index]));
        }

        combinationalSum(current, candidates, target, index + 1);
    }
}
