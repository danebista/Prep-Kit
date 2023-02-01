class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close= 0;
        int add =0;
        for (int i=0; i<s.length(); i++){
           if (s.charAt(i)=='(') open++;
           if (s.charAt(i)==')'){
                close++;
                if (close>open) {
                    close--;
                    //we are balancing paranthesis each time
                    add++;
                }
           }
        }
        return add+Math.abs(open-close);
    }
}

class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int open = 0;
        int res = 0;
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                open--;
                if (open < 0) {
                    res++;
                    open++;
                }
            }
        }
        
        int close = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == ')'){
                close++;
            } else {
                close--;
                if (close < 0) {
                    res++;
                    close++;
                }
            }
        }
        
        return res;
    }
    
}