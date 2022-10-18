public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s.length() == t.length()) {
            return checkReplace(s, t);
        } else {
            if (s.length() > t.length())
                return isOneEditDistance(t, s);
            return checkInsertOrDelete(s, t);
        }
    }

    public boolean checkReplace(String s, String t) {
        boolean isDuplicate = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i) && isDuplicate)
                return false;
            else if (s.charAt(i) != t.charAt(i)) {
                isDuplicate = true;
            }
        }

        return isDuplicate;
    }

    public boolean checkInsertOrDelete(String s, String t) {
        int i = 0;
        int j = 0;
        if (t.length() - s.length() > 1)
            return false;
        while (j < t.length()) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length() && j == t.length();
    }
}
