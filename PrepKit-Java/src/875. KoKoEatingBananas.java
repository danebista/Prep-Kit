
    
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        long lo=1, hi=1000000000;
        long ans = Integer.MAX_VALUE;
        while (lo<=hi){
            long mid= (lo+hi)/2, cnt=0;
            for (int p: piles) 
                cnt+=p%mid==0?p/mid: 1+p/mid;
            if (cnt<=H) {
                hi=mid-1;
                ans=Math.min(ans, mid);
            }
            else lo=mid+1;
        }
        return (int)ans;
    }
}

