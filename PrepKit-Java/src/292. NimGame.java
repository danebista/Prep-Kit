class Solution {
    Boolean[] nos;

    public boolean canWinNim(int n) {
        nos = new Boolean[n + 1];
        return helper(n);

    }

    public boolean helper(int n) {
        if (n <= 3)
            return nos[n] = true;
        if (nos[n] != null)
            return nos[n];
        for (int i = 1; i <= 3; i++) {

            if (!helper(n - i)) {
                nos[n] = true;
                return true;
            }
        }

        return nos[n] = false;
    }
}
