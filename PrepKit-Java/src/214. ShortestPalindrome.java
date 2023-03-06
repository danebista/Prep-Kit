
// Shortest Palindrome Java
public class Solution {
    public String shortestPalindrome(String s) {
       int lastIndex=0;
       if (s==null || s.length()==0) return s;
       for (int i=s.length()-1; i>=0; i--){
           if (isPalindrome(s, 0, i)){
               lastIndex= i;
               break;
           }
       }
       if (lastIndex==s.length()-1) return s;
       StringBuilder sb = new StringBuilder(s.substring(lastIndex+1));
       sb.reverse();
       String take = sb.toString();
       return take+s;
    }

    public boolean isPalindrome(String s, int l, int r){
        if (s==null || s.length()==0) return false;
        while (l<=r){
            if (s.charAt(l++)!=s.charAt(r--)) return false;
        }

        return true;
    }

   
}
