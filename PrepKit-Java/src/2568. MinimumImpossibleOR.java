class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < 32; i++) {
            int n = 1 << i;
            if(!set.contains(n)) return n;
        }
        return -1;
    }
}
