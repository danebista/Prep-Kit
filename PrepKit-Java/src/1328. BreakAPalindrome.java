class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length()==1) return "";
        StringBuilder sb = new StringBuilder();
        int index=-1;
        for (int i=0; i< palindrome.length()/2; i++){
            if (palindrome.charAt(i) !='a'){
                index = i;
                break;
            }
        }
        if (index==-1) return palindrome.substring(0,palindrome.length()-1)+"b";
        
        return palindrome.substring(0,index)+"a"+palindrome.substring(index+1);
     }
}
