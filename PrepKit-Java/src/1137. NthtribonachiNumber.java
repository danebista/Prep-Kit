class Solution {
    int []dp;
    public int tribonacci(int n) {
        
        int prev=0;
        int curr=1;
        int next=1;
        if (n==0) return 0;
        if(n==1 || n==2) return 1;
        for (int i=3; i<=n; i++){
            int sum = next+curr+prev;
            prev=curr;
            curr=next;
            next=sum;
        }
        return next;
    }
}
