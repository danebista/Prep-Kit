class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res= new int[spells.length];
        int i=0;
        for (int spell: spells){
            int l=0;
            int r=potions.length-1;
            int index=-1;
            while (l<=r){
                int m=l+(r-l)/2;
                long l1 = potions[m]*1L;
                long l2 = spell*1L;
                long val = l1*l2;
                if (val>=success){
                    index=m;
                    r=m-1;
                }
                else {
                    l=m+1;
                }
            }
            if (index==-1){
                res[i++]=0;
            }
            else{
                res[i++]=potions.length-index;
            }

        }

        return res;
    }
}
