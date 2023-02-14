class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums.clone();
    }
    
    public int pick(int target) {
        while (true){
            int rand=(int)Math.floor(Math.random() * nums.length);
            if (nums[rand]==target) return rand;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */