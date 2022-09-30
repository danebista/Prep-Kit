class Solution {
    public int lastRemaining(int n) {
        int remains = n;
        int head = 1;
        int start = 1;
        boolean left = true;

        while (remains > 1) {
            if (left || remains % 2 == 1) {
                head = head + start;
            }

            remains = remains / 2;
            start = start * 2;
            left = !left;
        }
        return head;
    }
}
