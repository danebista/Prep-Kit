class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*') {
                char c = s.charAt(i);
                List<Integer> left = diffWaysToCompute(s.substring(0, i));
                List<Integer> right = diffWaysToCompute(s.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        if (c == '-') {
                            result.add(l - r);
                        } else if (c == '+') {
                            result.add(l + r);
                        } else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            int val = Integer.valueOf(s);
            result.add(val);
        }

        return result;

    }
}
