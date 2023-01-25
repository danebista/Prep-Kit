public class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int ans=arr[arr.length-1]-arr[0];
        for(int i=1;i<n;i++){
            int mi = Math.min(arr[0]+k, arr[i]-k);
            int ma = Math.max(arr[arr.length-1]-k, arr[i-1]+k);
            ans = Math.min(ans, ma-mi);
        }
        return ans;
    }
} {
    
}
