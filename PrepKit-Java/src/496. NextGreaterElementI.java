class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashmap.put(nums1[i], i);
        }
        int[] results = new int[nums1.length];

        Stack<Integer> stack = new Stack();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = -1;
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                val = stack.peek();
            stack.push(nums2[i]);
            if (hashmap.containsKey(nums2[i])) {
                results[hashmap.get(nums2[i])] = val;
            }
        }

        return results;

    }
}
