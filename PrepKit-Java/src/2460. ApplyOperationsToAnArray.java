class Solution {
    public int[] applyOperations(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        return nums;
    }
}

class Solution {
    public int[] applyOperations(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
             if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }       
        }
        
        return nums;
      }
    }