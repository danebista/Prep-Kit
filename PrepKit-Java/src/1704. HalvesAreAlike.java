class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i)))
                count++;
            if (set.contains(s.charAt(i + s.length() / 2)))
                count--;
        }
        return count == 0;
    }
}
