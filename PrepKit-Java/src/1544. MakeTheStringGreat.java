class Solution {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        int i = 0;
        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
                continue;
            } else {
                if (Math.abs(stack.peek() - arr[i]) == 32) {
                    stack.pop();
                    i++;
                    continue;
                }
                stack.push(arr[i]);
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
