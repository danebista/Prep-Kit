class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = new int[arr.length];
        int[] pse = new int[arr.length];
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
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (long) (nse[i] * pse[i]) * arr[i];
            sum %= mod;
        }
        return (int) sum;
    }
}
