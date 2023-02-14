class Solution {
    int[] weight;

    public Solution(int[] w) {
        this.weight=new int[w.length];
        for (int i=0; i<w.length; i++){
            if (i==0) weight[i]=w[i];
            else
            weight[i]=weight[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
       int rand = (int)Math.floor(Math.random() * weight[weight.length-1])+1;
       int l=0;
       int r = weight.length-1;
       while (l<=r){
           int mid = l+(r-l)/2;
           if (weight[mid]==rand){
               return mid;
           }
           else if (weight[mid]<rand){
               l=mid+1;
           }
           else{
               r=mid-1;
           }
       }

       return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

