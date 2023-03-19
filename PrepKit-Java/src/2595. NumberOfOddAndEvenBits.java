class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int countOdd = 0;
        int countEven = 0;
        for (int i=0; i<32; i++){
            if ((n>>i & 1)==1){
                if (i%2==0) countEven++;
                else countOdd++;
            }
        }
        
        res[0]= countEven;
        res[1]=countOdd;
        return res;
    }
}
