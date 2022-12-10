class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // if we don't do this or if we don't use while true and break , the inital case
        // satisifies while condition
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
       for (int i=0; i<nums.length; i++){
           int index = Math.abs(nums[i])-1;
           if (nums[index]<0) return Math.abs(nums[i]);
           nums[index] = -nums[index]; 
       }
       return -1;
    }
}
