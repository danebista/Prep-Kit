class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min =1;
        int max = 0;
        for (int i=0; i< bloomDay.length; i++){
            max= Math.max(max, bloomDay[i]);
        }

        if (((long)m * (long)k) > (long)bloomDay.length) return -1;
        int ans = Integer.MAX_VALUE;
        while (min<=max){
            int mid = min + (max-min)/2;
            if (ok(bloomDay, m, k , mid)){
                ans = Math.min(ans, mid);
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }

        return ans;
    }

    public boolean ok(int[]bloomDay, int m, int k, int mid){
       int adjacent=0;
       int result = 0;
       for (int i=0; i< bloomDay.length; i++){
           if (bloomDay[i]<=mid){
               adjacent++;
               if (adjacent==k){
                   result++;
                   adjacent=0;
               }
           }
           else{
               adjacent=0;
           }
       }

       if (result>=m) return true;
       return false;
    }
}
