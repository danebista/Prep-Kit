class Solution {
    int globalMin;
    public int minCapability(int[] nums, int k) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i=0; i< nums.length; i++){
          min = Math.min(min, nums[i]);
          max = Math.max(max, nums[i]);
      }
      int low = min;
      int high = max;
      int result = Integer.MAX_VALUE;
      
     while(low<=high){
          int mid = low+(high-low)/2;
          
          if (capacityBearer(mid, nums, k)){
              result = Math.min(result, mid);
              high=mid-1;
          }
          else {
              low=mid+1;
          }
      }
      return result;
    }
    
    public boolean capacityBearer(int mid, int[] nums, int k){
        for (int i=0; i< nums.length; i++){
            if (nums[i]<= mid){
                k--; i++;
            }
            if (k==0) return true;
        }
        return false;
    }
    
    /*public void helper(int[]nums, int k, int index, int current, int[][][]dp){
        if (index>=nums.length){
            if (k==0){
               globalMin= Math.min(globalMin, current);
        
            }
            return;
        }
        
        if (k==0){
            globalMin= Math.min(globalMin, current);
            return;
        }
        
        helper(nums, k-1, index+2, Math.max(current,nums[index]));
        helper(nums, k, index+1, current);
    }*/
}
