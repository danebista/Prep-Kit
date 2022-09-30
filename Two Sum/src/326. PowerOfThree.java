class Solution {
    public boolean isPowerOfThree(int n) {
        long divider = 3;
        long num = n;
        if (num == 1)
            return true;
        while (divider < num) {
            divider = divider * 3;
        }
        return divider == num;
    }
}
