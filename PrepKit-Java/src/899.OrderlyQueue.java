class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();

        if (k > 1) {
            Arrays.sort(arr);
            return new String(arr);
        }

        String min = s;
        for (int i = 0; i < arr.length; i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (min.compareTo(temp) > 0)
                min = temp;
        }
        return min;

    }
}
