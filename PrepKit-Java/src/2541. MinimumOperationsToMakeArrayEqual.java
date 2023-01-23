class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long res = 0;
        long increment=0;
        long decrement=0;
        if (k==0) {
          for (int i=0; i<nums1.length; i++){
              if (nums1[i]!=nums2[i]) return -1;
          }
          return 0;
        }
        
        for (int i=0; i<nums1.length; i++){
            if (Math.abs(nums1[i]-nums2[i]) % k!=0) return -1;

            if (nums1[i]< nums2[i]){
                decrement+=Math.abs(nums1[i]-nums2[i])/k;
            }
            else {
                increment+=Math.abs(nums1[i]-nums2[i])/k;
            }
        }
        
        return increment == decrement ? increment : -1; 
    }
}
