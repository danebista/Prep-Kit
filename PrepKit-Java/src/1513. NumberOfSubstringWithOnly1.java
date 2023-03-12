class Solution {
    public int numSub(String s) {
       int count =0;
       int res = 0;
       int mod= (int)1e9+7;
       for (int i=0; i<s.length(); i++){
           if (i==0){
               if (s.charAt(i)!='1') continue;
            count=1;
            res+=count;
           }
           else {
               if (s.charAt(i)==s.charAt(i-1) && s.charAt(i)=='1'){
                   count+=1;
                   count = count%mod;
                   res+=count;
                   res= res%mod;
                   
               }
               else if (s.charAt(i)=='1') {
                   
                   count=1;
                   res+=count;
                   res= res%mod;
               }
           }
       }

       return res%mod; 
    }
}


//0110111
// 2nd index 1;
// 3rd index 1+1=2
//total till now 3;
// 5 th index 1;
// 6 th index 2;
// 7th index 3;
// total 6;
//hence all total 9;

// so just look at consecutive and ad
