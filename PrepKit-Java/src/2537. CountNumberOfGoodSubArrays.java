class Solution {
    public long countGood(int[] nums, int k) {
       HashMap<Integer, Integer> hashmap = new HashMap<>();
       int count=0;
       long res=0;
       int l=0;
       for (int i=0; i< nums.length; i++){
           if (hashmap.containsKey(nums[i])){
               count+=hashmap.get(nums[i]);
           }
           
           hashmap.put(nums[i], hashmap.getOrDefault(nums[i],0)+1);
           
           while (count>=k){
               res+=nums.length-i;
               hashmap.put(nums[l], hashmap.getOrDefault(nums[l],0)-1);
               if (hashmap.get(nums[l])<=0) hashmap.remove(nums[l]);
               if (!hashmap.containsKey(nums[l])) {
                   l++;
                   continue;
               }
               count-=hashmap.get(nums[l]);
               l++;
           }

       }

       return res;
    }
}
