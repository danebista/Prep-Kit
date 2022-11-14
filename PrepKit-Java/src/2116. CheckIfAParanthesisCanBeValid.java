class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> unlocked = new Stack();
        if (s.length() % 2 != 0)
            return false;
        Stack<Integer> open = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else {
                if (s.charAt(i) == '(') {
                    open.push(i);
                } else {
                    if (!open.isEmpty()) {
                        open.pop();
                    } else if (!unlocked.isEmpty()) {
                        unlocked.pop();
                    }

                    else {
                        return false;
                    }
                }
            }
        }
        while (!open.isEmpty()) {
            if (!unlocked.isEmpty() && unlocked.peek() > open.peek()) {
                unlocked.pop();
                open.pop();
            } else {
                return false;
            }
        }
        int count = 0;
        while (!unlocked.isEmpty()) {
            unlocked.pop();
            count++;
        }
        return open.isEmpty() && unlocked.isEmpty() && count % 2 == 0;
    }
}
