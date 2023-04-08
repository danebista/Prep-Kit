class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length()<=k)return "0";
        Stack<Character> stack=new Stack();
        for (int i=0; i<num.length(); i++){
            if (stack.isEmpty()) stack.push(num.charAt(i));
            else{

                while (!stack.isEmpty() && k>0
                && Character.getNumericValue(stack.peek())>Character.getNumericValue(num.charAt(i)))               {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
                
            }
        }
        while (k>0){
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) return "0";
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
    
        while (res.length()>0 && res.charAt(0)=='0'){
            res=res.substring(1);
        }
        if (res.length()==0) return "0";
        return res;
    }
}

