class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p1 = 0;
        int p2 = 0;
        int w1 = 0;
        int w2 = 0;
        while (w1 < word1.length && w2 < word2.length) {
            String tem1 = word1[w1];
            String tem2 = word2[w2];

            if (tem1.charAt(p1) != tem2.charAt(p2))
                return false;

            if (p1 < tem1.length() - 1) {
                p1++;
            }

            else {
                p1 = 0;
                w1++;
            }

            if (p2 < tem2.length() - 1) {
                p2++;
            } else {
                p2 = 0;
                w2++;
            }
        }

        return w1 == word1.length && w2 == word2.length;
    }
}
