class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int count=0;
        if (tokens.length==0)return 0;
        if (power==0)return 0;
        if (tokens[0]>power) return count;
        int low=0;
        int high=tokens.length-1;
        int max = Integer.MIN_VALUE;
        while (low<=high){
            if (tokens[low]<= power){
                count++;
                power-=tokens[low];
                low++;
            }
            else {
                power+=tokens[high];
                count--;
                high--;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}

