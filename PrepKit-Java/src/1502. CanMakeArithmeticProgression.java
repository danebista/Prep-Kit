class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int curr=0;
        for (int i=0; i< arr.length-1; i++){
            int value=0;
            if (i==0){
                curr = arr[i+1]-arr[i];
            }
            else {
                value = arr[i+1]-arr[i];
                if (curr!=value) return false;
            }
        }

        return true;
    }
}