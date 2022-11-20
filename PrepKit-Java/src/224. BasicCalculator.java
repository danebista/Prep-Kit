class Solution {
    int index;

    public int calculate(String s) {
        char[] arr = s.toCharArray();
        index = 0;
        return helper(arr);
    }

    public int helper(char[] arr) {
        int sum = 0;
        int operator = 1;

        while (index < arr.length) {
            if (arr[index] == ')') {
                break;
            }

            else if (arr[index] == '(') {
                index++;
                sum += operator * helper(arr);
            }

            else if (arr[index] == '+') {
                operator = 1;
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (Character.isDigit(arr[index])) {
                StringBuilder sb = new StringBuilder();
                while (index < arr.length && Character.isDigit(arr[index])) {
                    sb.append(arr[index++]);
                }
                int value = Integer.parseInt(sb.toString());
                index--;
                sum += operator * value;
            }
            index++;
        }
        return sum;
    }
}