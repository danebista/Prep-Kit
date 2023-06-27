class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int []> values = new PriorityQueue<>((a,b)->(a[0]+a[1]-b[0]-b[1]));
        for (int i=0; i< nums1.length; i++){
            if (values.size()>=k) break;
            values.offer(new int[]{nums1[i], nums2[0], 0});
        }
        List<List<Integer>>result = new ArrayList<>();
        while (k>0 && !values.isEmpty()){
            int[] val = values.poll();
            result.add(Arrays.asList(val[0], val[1]));
            if (val[2]<(nums2.length-1)){
               values.offer(new int[]{val[0], nums2[val[2]+1], val[2]+1});
            }
            k--;
        }

        return result;
    }
}