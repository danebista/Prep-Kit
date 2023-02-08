public class Solution {
    /**
     * @param sweetness: an integer array
     * @param k: an integer
     * @return:  return the maximum total sweetness of the piece
     */
    public int maximizeSweetness(int[] sweetness, int k) {
        // write your code here
        if (k> sweetness.length) return 0;
        int low=1;
        int high =0;
        for(int i=0; i< sweetness.length; i++){
            high+= sweetness[i];
        }

        int ans = Integer.MIN_VALUE;

        while (low<=high){
            int mid = low+(high-low)/2;
            if (calculateMax(mid, sweetness, k+1)){
                ans = Math.max(ans, mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;

    }
    public boolean calculateMax(int mid, int[] sweetness, int k){
        int current =0;
        int count=0;
        for (int i=0; i<sweetness.length; i++){
            current+=sweetness[i];
            if (current>=mid){
                count++;
                current=0;
            }
        }
        if (count>=k) return true;
        return false;
    }
}