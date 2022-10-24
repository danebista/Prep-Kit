class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, "", 0);
    }

    public int helper(List<String> arr, String current, int index) {
        HashSet<Character> result = new HashSet<>();
        for (Character c : current.toCharArray()) {
            if (!result.add(c))
                return 0;
        }
        int max = current.length();
        for (int i = index; i < arr.size(); i++) {
            max = Math.max(max, helper(arr, current + arr.get(i), i + 1));
        }

        return max;
    }
}
