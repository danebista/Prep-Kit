class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> current = new ArrayList();

        helper(result, current, 0, s);
        return result;
    }

    public void helper(List<List<String>> result, List<String> current, int index,
            String s) {

        if (index == s.length()) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                helper(result, current, i + 1, s);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
