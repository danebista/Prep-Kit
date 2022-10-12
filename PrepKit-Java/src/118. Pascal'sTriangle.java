class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList();

        List<Integer> baseCase = new ArrayList();
        baseCase.add(1);
        pascalsTriangle.add(baseCase);

        for (int i = 1; i < numRows; i++) {
            List<Integer> triangleInput = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangleInput.add(1);
                } else {
                    triangleInput.add(pascalsTriangle.get(i - 1).get(j - 1)
                            + pascalsTriangle.get(i - 1).get(j));
                }
            }
            pascalsTriangle.add(triangleInput);
        }

        return pascalsTriangle;
    }
}
