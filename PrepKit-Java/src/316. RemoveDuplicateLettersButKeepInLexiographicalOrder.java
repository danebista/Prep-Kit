class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }

        boolean[] seenIndex = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (seenIndex[c - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > c - 'a' && lastIndex[stack.peek()] > i) {
                int val = stack.pop();
                seenIndex[val] = false;
            }

            stack.push(c - 'a');
            seenIndex[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = (char) (stack.pop() + 'a');
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
