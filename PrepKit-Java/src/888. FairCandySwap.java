class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //sum(a)-a[i]+b[j]= sum(b)-b[j]+a[i]
        //2[a] = sum(a)-sum(b)+2*b
        //[a] = (sum(a)-sum(b)+2*b)/2;
      
        int sumA=0;
        HashSet<Integer> hashset = new HashSet<>();
        for (int i=0; i< aliceSizes.length; i++){
            sumA+=aliceSizes[i];
            hashset.add(aliceSizes[i]);
        }
        int sumB=0;
        for (int j=0; j< bobSizes.length; j++){
            sumB+=bobSizes[j];
        }
        int[]res = new int[2];
        for (int b: bobSizes){
            int x = (sumA-sumB+2*b)/2;
            if (hashset.contains(x)){
                res[0]=x;
                res[1]=b;

                return res;
            }
        }

        return res;
    }
}
