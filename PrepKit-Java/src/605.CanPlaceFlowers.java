class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        if (n>flowerbed.length) return false;
        for (int i=0; i< flowerbed.length; i++){
            if (flowerbed.length==1 && flowerbed[i]==0 && n==1) {
                return true;
            }
            else if (flowerbed.length==1){
                return false;
            }
            
            if (i==0 && flowerbed[i+1]!=1 && flowerbed[i]==0){
                n-=1;
                flowerbed[i]=1;
            }
            else if (i>0 && i<flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]!=1
             && flowerbed[i+1]!=1){
                n-=1;
                flowerbed[i]=1;
            }
            else if (i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]!=1){
                n-=1;
                flowerbed[i]=1;
            }
            if (n==0) return true;
        }

        return false;
        
    }
}

