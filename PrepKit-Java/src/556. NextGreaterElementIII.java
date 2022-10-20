class Solution {
    public int nextGreaterElement(int n) {
        if (n > Integer.MAX_VALUE)
            return -1;
        String nums = Integer.toString(n);

        int i = 0;
        int[] arr = new int[nums.length()];
        for (char c : nums.toCharArray()) {
            arr[i] = c - '0';
            i++;
        }

        i = arr.length - 2;
        int j = arr.length - 1;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i < 0)
            return -1;
        while (j >= 0 && arr[j] <= arr[i])
            j--;
        if (j < 0)
            return -1;

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);

        long res = 0;

        for (i = 0; i < arr.length; i++) {
            res = res * 10 + arr[i];
        }
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
