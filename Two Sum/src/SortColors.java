class SortColors {
    public static void main(String args[]) {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 2 };
        sortList(arr);
        return;
    }

    public static void sortList(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            if (array[mid] == 0) {
                swapper(array, low, mid);
                mid++;
                low++;
            } else if (array[mid] == 2) {
                swapper(array, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void swapper(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
