class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stackBrack = new Stack<>();
        Stack<Integer> stackStar = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackBrack.push(i);
            } else if (s.charAt(i) == '*') {
                stackStar.push(i);
            } else {
                if (!stackBrack.isEmpty()) {
                    stackBrack.pop();
                } else if (!stackStar.isEmpty()) {
                    stackStar.pop();
                } else {    
                    return false;
                }
            }

        }
        // *()(
        // )*()

        while (!stackBrack.isEmpty()) {
            if (!stackStar.isEmpty() && stackStar.peek() > stackBrack.peek()) {
                stackStar.pop();
                stackBrack.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean checkValidString(String s) {
        int leftmax = 0;
        int leftmin = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftmax++;
                leftmin++;
            } else if (s.charAt(i) == '*') {
                leftmax++;
                leftmin--;
            } else {
                leftmax--;
                leftmin--;
            }

            if (leftmax < 0)
                return false;
            leftmin = Math.max(leftmin, 0);

        }

        return leftmin == 0;
    }
}
