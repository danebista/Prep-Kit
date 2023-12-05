class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
         Arrays.sort(piles);
     int lim =  n /3 ;
        int ans = 0;
        int index= n-2;
       
     for( int i= 0;i<lim ; i++ ) { 
        ans += piles[index];
        index -= 2; 
         
     }
     return ans;
    }
}

// just think of it in plain greedy terms