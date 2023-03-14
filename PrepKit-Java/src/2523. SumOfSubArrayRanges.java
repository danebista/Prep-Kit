class Solution {
    public int[] closestPrimes(int left, int right) {
         int pre=-1;
         int num=-1;;
         int min = Integer.MAX_VALUE;
         int storedPre = -1;
         int storedNum=-1;
         for (int i=left; i<=right; i++){
             if (isPrime(i)){
               
                 if (pre==-1) pre=i;
                 else if (num==-1){
                    num=i;
                    min=num-pre;
                    storedPre=pre;
                    storedNum=i;
                    continue;
                 }
                
                 else {
                     pre = num;
                     num=i;
                     if (num-pre< min){
                         min = num-pre;
                         storedPre=pre;
                         storedNum=num;
                     }
                }
             }
         }

         if (storedPre==-1 || storedNum==-1){
             return new int[]{-1,-1};
         }
         return new int[]{storedPre, storedNum};
    }

    public boolean isPrime(int num){
        if (num==1) return false;
        if (num==2) return true;
        for (int i=2; i*i<=num; i++){
            if (num%i==0) return false;
        }

        return true;
    }
}