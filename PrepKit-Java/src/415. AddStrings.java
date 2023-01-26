class Solution {
    public String addStrings(String num1, String num2) {
        int carry =0;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        int i=num1.length()-1;
        int j = num2.length()-1;
        while (i>=0 || j>=0){
            sum=0;
            if (i>=0){
                sum+=num1.charAt(i)-'0';
                i--;
            }

            if (j>=0){
                sum+=num2.charAt(j)-'0';
                j--;
            }

            sum+= carry;
            carry = sum /10;
            sum %=10;
            res.append(sum);

        }

        if (carry!=0){
            res.append(carry);
        }

        return res.reverse().toString();
    }
}


