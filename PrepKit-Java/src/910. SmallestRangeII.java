class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int diff=nums[nums.length-1]-nums[0];
    
        for (int i=1; i<nums.length; i++){
            int max = Math.max(nums[nums.length-1]-k, nums[i-1]+k);
            int min = Math.min(nums[0]+k, nums[i]-k);

            diff = Math.min(diff, max-min);
        }

        return diff;
    }
}


// Something like this may happen

//134
//  i

// if I increase i-1 and decrease i
// then array becomes 1,1,6
// hence max between nums[i-1]+k, nums[n-1]-k
// hence min between nums[0]+k, nums[i]-k