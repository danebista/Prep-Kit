class Solution {
    int[] result;
    int totalMaxPoints;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        result = new int[aliceArrows.length];

        helper(numArrows, aliceArrows, 0, new int[aliceArrows.length], 0);
        int sum = 0;
        for (int res : result) {
            sum += res;
        }
        if (sum == numArrows)
            return result;
        result[0] += numArrows - sum;
        return result;
    }

    public void helper(int numArrows, int[] aliceArrows, int maxPoints, int[] currentList, int index) {
        if (index >= aliceArrows.length) {

            if (totalMaxPoints < maxPoints) {

                totalMaxPoints = maxPoints;

                result = currentList.clone();
            }
            return;
        }
        if (numArrows > aliceArrows[index]) {
            int saved = currentList[index];
            currentList[index] = aliceArrows[index] + 1;
            helper(numArrows - aliceArrows[index] - 1, aliceArrows, maxPoints + index,
                    currentList, index + 1);
            currentList[index] = saved;
        }

        helper(numArrows, aliceArrows, maxPoints, currentList, index + 1);
    }
}
