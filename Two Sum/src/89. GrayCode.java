class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        result.add(1);
        int inter = 2;
        while (n > 1) {
            int size = result.size();
            for (int i = size - 1; i >= 0; i--) {
                result.add(inter + result.get(i));
            }

            inter *= 2;
            n = n - 1;
        }
        return result;
    }
}
