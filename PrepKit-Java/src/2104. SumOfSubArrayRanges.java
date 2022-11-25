class Solution {
    public long subArrayRanges(int[] arr) {
        long[] nse = new long[arr.length];
        long[] pse = new long[arr.length];
        long[] nge = new long[arr.length];
        long[] pge = new long[arr.length];

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                nse[i] = i - stack.peek();
            else
                nse[i] = i + 1;
            stack.push(i);
        }

        while (!stack.isEmpty())
            stack.pop();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                nge[i] = i - stack.peek();
            else
                nge[i] = i + 1;
            stack.push(i);
        }

        while (!stack.isEmpty())
            stack.pop();
        long mod = (long) (1e9 + 7);
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                pse[i] = stack.peek() - i;
            else
                pse[i] = arr.length - i;
            stack.push(i);
        }

        while (!stack.isEmpty())
            stack.pop();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                pge[i] = stack.peek() - i;
            else
                pge[i] = arr.length - i;
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (nge[i] * pge[i] - nse[i] * pse[i]) * arr[i];
        }
        return sum;
    }
}
