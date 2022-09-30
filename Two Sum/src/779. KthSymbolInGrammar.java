class Solution {

    public int kthGrammar(int n, int k) {
        if (k == 0 || n == 1)
            return 0;
        double pow = Math.pow(2, n - 1);
        int mid = (int) Math.round(pow / 2);

        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }

    // Time Limit Exceeded
    public String helper(int n) {
        if (cache[n].equals(-1))
            return cache[n];
        if (n == 1) {
            return "0";
        }

        String val = helper(n - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }

        cache[n] = sb.toString();
        return cache[n];
    }
}
