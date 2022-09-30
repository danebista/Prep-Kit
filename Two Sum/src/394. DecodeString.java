class Solution {
    int index;

    public String decodeString(String s) {
        index = 0;
        return recur(s);

    }

    public String recur(String s) {
        int k = 0;
        String res = "";
        while (index < s.length()) {
            if (s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9) {
                System.out.println(s.charAt(index) - '0');
                k = k * 10 + s.charAt(index) - '0';
                index++;
            } else if (s.charAt(index) == '[') {
                index++;
                String value = recur(s);
                index++;
                while (k > 0) {
                    res += value;
                    k--;
                }
                k = 0;
            } else if (s.charAt(index) == ']') {
                break;
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
