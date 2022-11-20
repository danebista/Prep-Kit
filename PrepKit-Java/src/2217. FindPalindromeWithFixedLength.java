class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = (intLength - 1) / 2;
        long number = (long) Math.pow(10, n);
        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > (9 * number)) {
                ans[i] = -1;
                continue;
            }
            long tempNo = number;
            tempNo += queries[i];
            tempNo -= 1;

            StringBuilder newString = new StringBuilder();
            newString.append(tempNo);
            newString.reverse();
            if (intLength % 2 == 1)
                tempNo = tempNo / 10;
            StringBuilder newBuilder = new StringBuilder();
            newBuilder.append(tempNo);

            ans[i] = Long.parseLong(newBuilder.toString() + newString.toString());
        }
        return ans;
    }
}
