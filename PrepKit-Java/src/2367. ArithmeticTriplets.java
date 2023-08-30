class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set set = new HashSet();
        for(int num: nums)    set.add(num);
        int count = 0;
        for(int num : nums){
            if(set.contains(num + diff) && set.contains(num + diff*2)){
                count++;
            }
        }
        return count;
    }
}
