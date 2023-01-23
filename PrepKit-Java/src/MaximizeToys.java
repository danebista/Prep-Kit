
class Solution{
    static int toyCount(int N, int K, int arr[])
    {
        // code here
        Arrays.sort(arr);
        int sum =0;
        
        for (int i=0; i< arr.length; i++){
            sum+=arr[i];
            
            if (sum> K) return i;
        }
        
        return N;
    }
}

