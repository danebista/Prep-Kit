class Solution {
    public int numTrees(int n) {

        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        numbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                numbers[i] += numbers[j] * numbers[i - j - 1];
            }
        }

        return numbers[n];

    }
}


1 2 3
1*2+1*1+2*1