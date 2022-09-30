class Solution {
    public int fib(int n) {
        int prev = 0;
        if (n == 0)
            return 0;
        int curr = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;

        }

        return curr;
    }

}
