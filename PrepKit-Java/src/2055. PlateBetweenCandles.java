class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[]left = new int[s.length()];
        int[]right = new int[s.length()];
        int[]candleCounter = new int[s.length()];
        int prev=-1;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='|'){
                left[i]=i;
                prev=i;
            }
            else {
                left[i]=prev;
            }

            if (i==0){
                if (s.charAt(i)=='|'){
                    candleCounter[i]=1;
                }
            }
            else {
                if (s.charAt(i)=='|'){
                    candleCounter[i]=candleCounter[i-1]+1;
                }
                else {
                    candleCounter[i]=candleCounter[i-1];
                }
            }
        }

        prev=-1;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i)=='|'){
                right[i]=i;
                prev=i;
            }
            else {
                right[i]=prev;
            }
        }
        int[]res= new int[queries.length];
        int index=0;
        for (int[]query: queries){
            int lo= query[0];
            int ro= query[1];

            if (s.charAt(lo)=='|'){
                lo=query[0];
                
            }
            else {
                lo=right[query[0]];
            }
            System.out.println(lo);

            if (s.charAt(ro)=='|'){
                ro=query[1];
            }
            else {
                ro = left[query[1]];
            }
           

            if (lo==-1 || ro==-1 || lo>=ro){
                res[index++]=0;
            }
            else{
                res[index++]=(ro-lo+1)-(candleCounter[ro]-candleCounter[lo]+1);
            }
        }

        return res;

    
    }
}
