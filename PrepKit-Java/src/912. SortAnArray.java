class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[]nums, int l, int r){
        if (l>=r) return;
        int mid = l+(r-l)/2;
        mergeSort(nums, l , mid);
        mergeSort(nums, mid+1, r);
        
        merge(nums, l, mid, r);
    }

    public void merge(int[]nums, int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-(mid+1)+1;
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        
        for (int i=0; i< temp1.length; i++){
            temp1[i] = nums[l+i];
        }
        for (int j=0; j<temp2.length; j++){
            temp2[j] = nums[mid+1+j];
        }
        int k = l;
        int i=0;
        int j=0;
        while (i< temp1.length && j< temp2.length){
            if (temp1[i]< temp2[j]){
                nums[k++]=temp1[i++];
            }
            else {
                nums[k++]=temp2[j++];
            }
        }

        while (i< temp1.length){
            nums[k++] = temp1[i++];
        }
        while (j<temp2.length){
            nums[k++] = temp2[j++];
        }
    }
}
