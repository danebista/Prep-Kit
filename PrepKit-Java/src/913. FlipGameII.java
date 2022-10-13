public class Solution {
    /**
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    public boolean canWin(String s) {
        // write your code here
        if (s == null || s.length() < 2)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("++", i)) {
                if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2)))
                    return true;
            }
        }
        return false;
    }
}
