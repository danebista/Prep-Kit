public class Solution {
    /**
     * @param s: the expression string
     * @return: the answer
     */
    public int calculate(String s) {
        // Write your code here
        Stack<Character> opt = new Stack();
        Stack<Integer> opnd = new Stack();
        char[] se  = s.toCharArray();
        for (int i=0; i<se.length;i++){
            if (se[i]==' '){
                continue;
            }
            else if (se[i]=='('){
                opt.push(se[i]);
            }
            else if (se[i]-'0'>=0 && se[i]-'0'<=9){
                int nums=0;
                while(i<s.length() && se[i]-'0'>=0 && se[i]-'0'<=9){
                    nums = nums*10+(se[i]-'0');
                    i++;
                }
                i--;
                opnd.push(nums);
            }
            else if (se[i]==')'){
                while(opt.peek()!='('){
                    opnd.push(calculate(opt.pop(), opnd.pop(), opnd.pop()));
                }
                opt.pop();
            }
            else {
                while(!opt.isEmpty() && precedence(se[i], opt.peek())){
                    opnd.push(calculate(opt.pop(), opnd.pop(), opnd.pop()));
                }
                opt.push(se[i]);
            }
        }

        while (!opt.isEmpty()){
            opnd.push(calculate(opt.pop(), opnd.pop(), opnd.pop()));
        }

        return opnd.pop();
    }
    public int calculate(Character opt, int x, int y){
        if (opt=='*'){
            return x * y;
        }
        else if (opt=='-'){
            return y - x;
        }
        else if (opt=='+'){
            return x+y;
        }
    
        return y/x;
    } 

    public boolean precedence(Character later, Character former){
        if (former=='(' || former==')'){
            return false;
        }
        else if ((former =='+' || former == '-') 
        && (later == '*' || later == '/')){
            return false;
        }
        return true;
    }
}
