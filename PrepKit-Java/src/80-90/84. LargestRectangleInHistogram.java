class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftLargest = new int[heights.length];
        int[] rightLargest = new int[heights.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                leftLargest[i] = 0;
            else
                leftLargest[i] = stack.peek() + 1;

            stack.push(i);
        }

        while (!stack.isEmpty())
            stack.pop();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                rightLargest[i] = heights.length - 1;
            else
                rightLargest[i] = stack.peek() - 1;

            stack.push(i);
        }

        int max = 0;

        for (int i = 0; i < leftLargest.length; i++) {
            max = Math.max(max, (rightLargest[i] - leftLargest[i] + 1) * heights[i]);
        }

        return max;
    }
}
