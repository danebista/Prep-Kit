class Solution {
    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int i, int j) {
        if (i >= j)
            return 0;

        int mid = i + (j - i) / 2;

        int counter = mergeSort(nums, i, mid);
        counter += mergeSort(nums, mid + 1, j);
        counter += merge(nums, i, mid, j);
        
        return counter;
    }

    public int merge(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        int counter = 0;
        int i = low;
        while (i <= mid && j <= high) {
            if (nums[i] > (long) 2 * nums[j]) {
                counter += (mid + 1 - i);
                j++;
            } else {
                i++;
            }
        }

        int l = low;
        int r = mid + 1;
        List<Integer> temp = new ArrayList();

        while (l <= mid && r <= high) {
            if (nums[l] <= nums[r]) {
                temp.add(nums[l++]);
            } else {
                temp.add(nums[r++]);
            }
        }

        while (l <= mid)
            temp.add(nums[l++]);
        while (r <= high)
            temp.add(nums[r++]);

        for (int m = low; m <= high; m++) {
            nums[m] = temp.get(m - low);
        }

        return counter;
    }
}
