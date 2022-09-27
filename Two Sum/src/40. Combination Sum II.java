import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        helper(0, candidates, result, target, new ArrayList());

        return result;
    }

    public void helper(int index, int[] candidates, List<List<Integer>> result,
            int target, List<Integer> current) {

        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;

            current.add(candidates[i]);
            helper(i + 1, candidates, result, target - candidates[i], current);
            current.remove(new Integer(candidates[i]));
        }
    }
}
