class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0; i< s.length(); i++){
                Character curr=s.charAt(i);
                stack.push(s.charAt(i));
                if (s.charAt(i)=='c'){
                   boolean flag=false;
               
                    while(!stack.isEmpty() && stack.peek()=='c'){
                        stack.pop();
                        if (!stack.isEmpty()&& stack.peek()=='b'){
                            curr=stack.pop();
                            if (!stack.isEmpty()&& stack.peek()=='a'){
                                stack.pop();
                                flag=false;
                            }
                            else{
                              stack.push('b');
                              flag=true;
                            }
                        }
                        else{
                            flag=true;
                        }
                    }
                    if (flag) return false;
                   
                }       
        }

        return stack.isEmpty();
    }
}
