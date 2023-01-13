class Solution {
    
    //TLE
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int total=1;
        for (int i=3; i< n; i++){
            if (primeChecker(i)) total++;
        }

        return total;
    }
    public boolean primeChecker(int n){
        if (n==1) return false;
        
        for (int i=2; i*i<=n; i++){
            if (n%i==0) return false;    
        }
        return true;
    }
}

class Solution {
    public int countPrimes(int n) {
       boolean[]  primes = new boolean[n];
       int count =0;
       for (int i=2; i<n; i++){
           if (primes[i]==false) count++;
           for (int j=2; i*j<n; j++){
               primes[i*j] = true;
           }
       }
       return count;  
    }
}