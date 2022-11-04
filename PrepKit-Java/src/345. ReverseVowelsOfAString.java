class Solution {
    public String reverseVowels(String s) {
        if (s == null)
            return s;

        int l = 0;
        int r = s.length() - 1;
        String charSet = "AEIOUaeiou";
        char[] newChar = s.toCharArray();
        while (l < r) {
            while (l < r && !charSet.contains(newChar[l] + ""))
                l++;
            while (l < r && !charSet.contains(newChar[r] + ""))
                r--;

            char temp = newChar[l];
            newChar[l] = newChar[r];
            newChar[r] = temp;
            l++;
            r--;
        }

        return new String(newChar);
    }
}
