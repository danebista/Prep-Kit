class Solution {
    int count;
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        count = 0;

        for (int i=0; i<s.length(); i++){
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }
        return count;   
    }

    public boolean checkPalindrome(String s, int l, int r){

        while (l>=0 && r< s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--; 
            r++;
        }
        return true;
    }
}
