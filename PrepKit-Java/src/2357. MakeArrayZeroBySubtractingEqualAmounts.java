class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int n:nums){
            if (n==0) continue;
            hashset.add(n);
        }
        return hashset.size();
    }
}
