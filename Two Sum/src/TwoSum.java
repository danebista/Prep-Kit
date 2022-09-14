import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] value = twoSum.twoSumIndices(new int[] { 3, 4, 1, 2 }, 5);
        for (int val : value) {
            System.out.println(val);
        }
    }

    public int[] twoSumIndices(int nums[], int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[] {
                        i,
                        hashmap.get(target - nums[i])
                };
            }
            hashmap.put(nums[i], i);
        }

        throw new IllegalArgumentException("Sorry bros, couldn't process");
    }
}
