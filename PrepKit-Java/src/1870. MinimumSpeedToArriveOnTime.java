class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)1e9;
        int result = Integer.MAX_VALUE;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (valid(mid, hour, dist)){
                result = Math.min(result, mid);
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }

        result = result==Integer.MAX_VALUE? -1: result;
        return result;
    }

    public boolean valid(int validSpeed, double hrs, int[]dist){
        double sum = 0;
        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / validSpeed ;
            if (i != dist.length - 1) {
                sum += time == (int) time ? time : (int)time + 1;            
            } else {
                sum += time;
            }
        }
        return sum<=hrs;
    }
}
