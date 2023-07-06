class Solution {
    public int maximumProduct(int[] nums, int k) {
       int mod = (int)1e9+7;
       PriorityQueue<Integer> pq = new PriorityQueue<>();

       for (int i=0; i< nums.length; i++){
           pq.offer(nums[i]);
       }

       while (k>0){
           int val = pq.poll();
           val+=1;
           pq.offer(val);
           k--;
       }

       long val = 1L;
       while (!pq.isEmpty()){
           val = (val * pq.poll())% mod;
       }

       return (int)val;
    }
}
