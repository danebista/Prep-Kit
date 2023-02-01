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
