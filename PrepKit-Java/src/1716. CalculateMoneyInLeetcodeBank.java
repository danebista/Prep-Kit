class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int t;
        t=n%7==0? n/7: n/7 + 1;
        int days = 1;
        for (int i=1; i<=t; i++){
          int count = i;
          for (int j=i+1; j<(7+i); j++){
            if (days>=n) break;
            count = count+j;
            days ++;
          }
          ans+=count;
          days++;
        }

        return ans;
    }
}