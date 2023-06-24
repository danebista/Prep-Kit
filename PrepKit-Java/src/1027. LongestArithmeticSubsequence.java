class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> dp[] = new HashMap[n];
        for (int i=0; i< nums.length; i++){
            dp[i] = new HashMap<>();
        }
        int max  = 1;
        for (int i=1; i< n; i++){
            for (int j=0; j<i; j++){
                int diff = nums[i]-nums[j];
                int prev =dp[i].getOrDefault(diff,0);
                int withJ = dp[j].getOrDefault(diff, 1);
                int cmax = Math.max(prev, 1+withJ);
                dp[i].put(diff, cmax);
                max = Math.max(max,cmax);
            }
        }

        return max;

    }
}
