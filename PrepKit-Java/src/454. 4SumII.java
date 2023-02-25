class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       HashMap<Integer, Integer> hashmap = new HashMap<>();
       int n=nums1.length;
       for (int i=0; i< n; i++){
           for (int j=0; j< n; j++){
               
               hashmap.put((nums1[i]+nums2[j]), hashmap.getOrDefault((nums1[i]+nums2[j]),0)+1);
           }
       }
       
       int count=0;
       for (int i=0; i<n; i++){
           for (int j=0; j<n; j++){
               if (hashmap.containsKey((-nums3[i]-nums4[j]))) count+=hashmap.get(-nums3[i]-nums4[j]);
           }
       }

       return count;
   }
}
