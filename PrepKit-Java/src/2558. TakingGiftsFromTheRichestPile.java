class Solution {
    public long pickGifts(int[] gifts, int k) {
        while (k>0){
            int max = 0;
            int index = 0;
            for (int i=0;i<gifts.length; i++){
                max = Math.max(max, gifts[i]);
                if (max==gifts[i]){
                    index=i;
                }
            }
            gifts[index]=(int)Math.sqrt(gifts[index]);
            k--;
            
        }
        long sum = 0;
        for (int i=0; i< gifts.length; i++){
            sum+=gifts[i];
        }
        return sum;
    }
}