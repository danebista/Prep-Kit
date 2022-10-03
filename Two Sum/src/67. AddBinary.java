class Solution {
    public String addBinary(String a, String b) {
        int sum = 0;
        int carry = 0;
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (a_index >= 0 || b_index >= 0) {

            sum += carry;
            if (a_index >= 0)
                sum += a.charAt(a_index) - '0';

            if (b_index >= 0)
                sum += b.charAt(b_index) - '0';

            carry = sum / 2;
            sum = sum % 2;
            a_index--;
            b_index--;
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
