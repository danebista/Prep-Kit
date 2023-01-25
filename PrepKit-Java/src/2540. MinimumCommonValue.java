class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
            for (int num : nums1) {
                int idx = Arrays.binarySearch(nums2, num);
            
                if (idx >= 0)
                    return num;
            }
        
            return -1;
    }
}
