class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ne = new int[nums.length];
        Stack<Integer> stack = new Stack();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n])
                stack.pop();
            if (i < n) {
                if (!stack.isEmpty()) {
                    ne[i] = stack.peek();
                } else {
                    ne[i] = -1;
                }
            }
            stack.push(nums[i % n]);
        }

        return ne;
    }
}
