public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,-1);
        int sum=0;
        int max=0;
        for (int i=0; i< nums.length; i++){
            sum+=nums[i];
            if (hashmap.containsKey(sum-k)){
               max = Math.max(max, i-hashmap.get(sum-k));
            }
            if (!hashmap.containsKey(sum)){
                hashmap.put(sum, i);
            }
        }
        return max;
    }
}
/*(0,-1)
(1,1)
(5,2)
(3,3) res+= 3-(-1);4
(6, 4)
*/
