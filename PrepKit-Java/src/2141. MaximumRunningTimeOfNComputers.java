class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for (int i=0; i< batteries.length; i++){
            sum+= batteries[i];
        }

        long r = sum/n;
        long ans=0;
        Arrays.sort(batteries);
        long l = batteries[batteries.length-n];
        while (l<=r){
            long m = l+(r-l)/2;
            if (isValid(m, batteries, n)){
                ans = m;
                l = m+1;
            }
            else {
                r = m-1;
            }
        }
        return ans;
    }

    public boolean isValid(long mid, int[]batteries, int n){
        int k= batteries.length-1;
        while (k>=0 && batteries[k]>=mid){
            k--;
        }
        int remaining = n-(batteries.length-1-k);
        long temp = 0;
        while (k>=0){
            temp+= batteries[k];
            k--;
        }
        if (remaining<=0 || remaining * mid <= temp) return true;

        return false;
    }
}
s