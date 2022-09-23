class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int st = 0;
        int e = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = longestLengthAtIndexI(s, i, i);
            int l2 = longestLengthAtIndexI(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > e - st) {
                System.out.println(i + "-" + len);
                st = i - ((len - 1) / 2); // abbd when even length answer in longer length, it gives wrong answer
                e = i + (len / 2);
            }
        }
        return s.substring(st, e + 1);

    }

    public int longestLengthAtIndexI(String s, int l, int r) {
        if (s == null || l > r)
            return 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
