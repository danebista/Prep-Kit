class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String counter = countAndSay(n - 1);
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counter.length(); i++) {
            count++;
            if (i == counter.length() - 1 || counter.charAt(i) != counter.charAt(i + 1)) {
                result.append(count).append(counter.charAt(i));
                count = 0;
            }
        }

        return result.toString();
    }
}
