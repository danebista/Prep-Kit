class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int largest = arr.length;

        int i= arr.length-1;
        List<Integer> result = new ArrayList<>();

        while (i>=0){
            int index=0;
            for (int j=0; j<= i; j++){
                if (largest==arr[j]){
                    index=j;
                    break;
                }
            }
            flip(arr, 0, index);
            flip(arr, 0, i);
            
            result.add(index+1);
            result.add(i+1);
            i--;
            largest--;
        }
        return result;
    }

    public void flip (int[] arr, int i, int j){
        while (i<j){
            int temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
//Flip twice once to bring largest element to first and then shift it to the last.
