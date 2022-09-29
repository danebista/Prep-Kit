public class Solution {
    /**
     * @param n: the length of strobogrammatic number
     * @return: All strobogrammatic numbers
     *          we will sort your return value in output
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m) {
        List<String> result = new ArrayList();
        if (n == 0)
            return Arrays.asList("");
        if (n == 1)
            return Arrays.asList("0", "1", "8");
        List<String> values = helper(n - 2, m);

        for (String val : values) {
            if (n != m)
                result.add("0" + val + "0");
            result.add("1" + val + "1");
            result.add("8" + val + "8");
            result.add("6" + val + "9");
            result.add("9" + val + "6");
        }
        return result;
    }
}
