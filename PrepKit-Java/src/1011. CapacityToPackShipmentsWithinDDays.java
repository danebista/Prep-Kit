class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i< weights.length; i++){
            sum+=weights[i];
            min = Math.min(min, weights[i]);
        }
        int low = min;
        int high = sum;
        int result = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (isPossible(weights, days, mid)){
                result = Math.min(result, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }

    public boolean isPossible(int[] weights, int days, int mid){
        //WITHOUT STARTING WITH ONE DIFFICULT TO DO.
        int count = 1;
        int start = 0;
        for (int i=0; i< weights.length; i++){
            if (weights[i]> mid) return false;
            start+=weights[i];
            if (start>mid){
                count++;
                start=weights[i];
            }
        }
        if (start>mid){
                count++;
            }
        if (count<=days) return true;
        return false;
    }
}