class Solution {
    public String convert(String s, int numRows) {
        int b_len = 0;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        while (b_len < s.length()) {
            for (int i = 0; i < numRows && b_len < s.length(); i++) {
                sb[i].append(s.charAt(b_len));
                b_len++;
            }
            for (int i = numRows - 2; i > 0 && b_len < s.length(); i--) {
                sb[i].append(s.charAt(b_len));
                b_len++;
            }
        }
        StringBuilder temp = new StringBuilder();
        for (StringBuilder se : sb) {
            temp.append(se.toString());
        }
        return temp.toString();
    }
}
