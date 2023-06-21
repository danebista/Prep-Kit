class Solution {
    public int largestAltitude(int[] gain) {
       int gains=0;
       int max = 0;
       
       for (int i=0; i< gain.length; i++){
           gains = gain[i]+gains;
           max = Math.max(max, gains);
       } 

       return max;
    }
}
