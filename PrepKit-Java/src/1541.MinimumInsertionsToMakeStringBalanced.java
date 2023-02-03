
public class 1541.MinimumInsertionsToMakeStringBalanced {
    class Solution {
        public int minInsertions(String s) {
            int open=0;
            int res = 0;
            for (int i=0; i< s.length(); i++){
                if (s.charAt(i)=='('){
                    open++;
                }
                else{
                    //))(
                    if (open==0){
                        open++;
                        res+=1;
                    }
                    //remember both are different if here
                    //())
                    if (i+1<s.length() && s.charAt(i+1)==')'){
                         open--;
                         i++;
                    }
                    //()
                    else{
                        open--;
                        res+=1;
                    }
                }
            }
            return res+2*open;
        }
    }
}
