class Solution {
    public boolean increasingTriplet(int[] nums) {

        //  Find smallest before me
        // Find greatest after me

        //Similar to nge but instead of nge we are finding every 

        int[]left = new int[nums.length];
        int[] right =new int[nums.length];
        left[0]=nums[0];
        right[nums.length-1]=nums[nums.length-1];
        for (int i=1; i<nums.length; i++){
            left[i] =left[i-1] > nums[i]? nums[i]:left[i-1];
        } 
        System.out.println(Arrays.toString(left));
        for (int i=nums.length-2; i>=0; i--){
            right[i] =right[i+1]<nums[i]? nums[i]:right[i+1];
        }
        System.out.println(Arrays.toString(right));
        for (int i=0; i<nums.length; i++){
            if (left[i]<nums[i] && nums[i]<right[i]) return true;
        }
        return false;
    }
}