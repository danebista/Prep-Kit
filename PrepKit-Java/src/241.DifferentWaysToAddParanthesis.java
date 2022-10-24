class Solution {
    Map<String, List<Integer>> hashmap = new HashMap();

    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = hashmap.getOrDefault(s.substring(0, i), diffWaysToCompute(s.substring(0, i)));
                List<Integer> right = hashmap.getOrDefault(s.substring(i + 1), diffWaysToCompute(s.substring(i + 1)));

                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '-') {
                            result.add(l - r);
                        }
                        if (c == '*') {
                            result.add(l * r);
                        }
                        if (c == '+') {
                            result.add(l + r);
                        }
                    }
                }
            }
        }

        if (result.size() == 0)
            result.add(Integer.valueOf(s));

        hashmap.put(s, result);
        return result;
    }
}
