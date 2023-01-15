//TLE Solution

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        while (k>0){
            int temp = nums[nums.length-1];
            int previous = nums[0];
            for (int i=1; i<nums.length; i++){
                int current = nums[i];
                nums[i]= previous;
                previous = current;
            }
            nums[0] = temp;
            k--;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums, 0, nums.length-1);
       
        reverse(nums, 0, k-1);
       
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int i, int j){
        while (i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}