class Solution {
    public int countHomogenous(String s) {
        int count=0;
        int val=0;
        int mod = (int)1e9+7;
        for (int i=0; i< s.length(); i++){
            if (i==0){
                count+=1;
                val+=count;
            }
            else{
                if (s.charAt(i)==s.charAt(i-1)){
                    count+=1;
                    count=count%mod;
                }
                else{
                    count=1;
                }
                val+=count;
                val=val%mod;
            }
        }

        return val%mod;
    }
}

//if it appears singly add once, if multiple add accordingly