class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<Integer> hashset = new HashSet<>();
        for (int i=0; i< nums2.length; i++){
            hashset.add(nums2[i]);
        }

        HashSet<Integer> res = new HashSet<>();

        for (int i=0; i< nums1.length; i++){
            if (!hashset.contains(nums1[i])){
                res.add(nums1[i]);
            }
        }

        List<Integer> sim = new ArrayList<>(res);

        result.add(sim);

        hashset.clear();

        for (int i=0; i< nums1.length; i++){
            hashset.add(nums1[i]);
        }
        
        HashSet<Integer> results = new HashSet<>();

        for (int i=0; i< nums1.length; i++){
            hashset.add(nums1[i]);
        }
 
        for (int i=0; i<nums2.length; i++){
            if (!hashset.contains(nums2[i])){
                results.add(nums2[i]);
            }
        }

        List<Integer> r = new ArrayList<>(results);
        result.add(r);

        return result;
    }
}
