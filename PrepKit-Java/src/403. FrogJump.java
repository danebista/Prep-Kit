class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> set = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        int lastStone = stones[stones.length - 1];

        Map<Pair<Integer, Integer>, Boolean> dp = new HashMap<>();
        return memoApproach(set, lastStone, 0, 1, dp);
    }
    
    private boolean memoApproach(Set<Integer> stones, int lastStone, int i, int k, Map<Pair<Integer, Integer>, Boolean> dp) {
        if(i < 0 || i > lastStone || !stones.contains(i) || k == 0) return false;
        if(i == lastStone) return true;

        Pair<Integer, Integer> key = new Pair<>(i, k);
        if(dp.containsKey(key)) return dp.get(key);

        boolean smallJump = i > 0 && memoApproach(stones, lastStone, i + k - 1, k - 1, dp);
        boolean sameJump = memoApproach(stones, lastStone, i + k, k, dp);
        boolean bigJump = i > 0 && memoApproach(stones, lastStone, i + k + 1, k + 1, dp);

        boolean optimal = smallJump || sameJump || bigJump;
        dp.put(key, optimal);
        return optimal;
    }

}
