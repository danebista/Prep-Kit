class Solution {
    public int minCost(String colors, int[] neededTime) {
        int l=0;
        int r=1;
        int result=0;
       
        while (r<colors.length()){
            if (colors.charAt(l)==colors.charAt(r)){
                if (neededTime[l]>neededTime[r]){
                    result+=neededTime[r];
                }
                else{
                    result+=neededTime[l];
                    l=r;
                }
            }
            else {
                l=r;
            }
            r++;
        }
        return result;
    }
}
