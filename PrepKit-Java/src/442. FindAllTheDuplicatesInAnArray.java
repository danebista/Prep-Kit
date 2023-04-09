class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< nums.length; i++){
            int temp = Math.abs(nums[i])-1;
            if (nums[temp]<0){result.add(temp+1);}
            if (nums[temp]>0)nums[temp]=-nums[temp];
        }
        return result;
    }
}
