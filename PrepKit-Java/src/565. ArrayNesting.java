class Solution {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        int minVal = Integer.MIN_VALUE;
        for (int i=0; i< nums.length; i++){
            minVal = Math.max(minVal, helper(i, nums, hashset));
        }
        
        return minVal;
    }

    public int helper(int index, int[] nums, HashSet<Integer> hashset){
        int sum = 0;
        while (!hashset.contains(nums[index])){
            hashset.add(nums[index]);
            index = nums[index];
            sum+=1;
        }

        return sum;
    }
}