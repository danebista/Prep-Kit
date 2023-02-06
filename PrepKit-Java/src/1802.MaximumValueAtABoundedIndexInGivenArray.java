class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long nL = index;
        long nR = n-index-1; 
        long low = 1;
        long high = maxSum;
        long res = 0;
        while (low<=high){
            long l = 0;
            long r = 0;
            long mid = low+(high-low)/2;
            long m = mid-1;
            long sum = mid;
            if (nR<=m){
                r = m*(m+1)/2-(m-nR)*(m-nR+1)/2;
            }
            else{
                r = m*(m+1)/2+1*(nR-m);
            }

            if (nL<=m){
                l = m*(m+1)/2-(m-nL)*(m-nL+1)/2;
            }
            else{
                l = m*(m+1)/2+1*(nL-m);
            }

            sum+=l+r;

            if (sum<=maxSum){
                res=Math.max(res,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }

        return (int)res;     
    }
}

//Index          012345
//1st Case Value 898765
//2nd Case Value 232111
// Lets say we are trying to maximize index 1. Twocases might occur n*(n+1)/2 - (n-r)*(n-r+1)/2
//2nd Case if n*(n+1)/2+1*(r-m) when right spaces is more than 1 to m of the number we want to ///insert
