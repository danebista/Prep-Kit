public class Solution {
    public int[] primesum(int A) {
        if (A%2==1){
            int checker = A-2;
            if (isPrime(checker)) return new int[]{2, checker};
        }
        else {
            if (A==4) return new int[]{2,2};
            for (int i=3; i*i<=A; i+=2){
                if (isPrime(i) && isPrime(A-i)){
                    return new int[]{i,A-i};
                }
            }
        }
        return new int[]{-1,-1};
    }
    
    public int isPrime(int num){
        if (n==1) return false;
        for (int i=2; i*i<=num; i++){
            if (num%i==0) return false;
        }
        return true;
    }
}
