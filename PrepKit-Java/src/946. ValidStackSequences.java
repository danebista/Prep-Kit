class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       int left=0;
       int right=0;
       Stack<Integer> stack= new Stack<>();
       for (int i=0;i< popped.length; i++){
           if (!stack.isEmpty() && stack.peek()==popped[i]) stack.pop();
           else {
               while (left<pushed.length && pushed[left]!=popped[i]){
                   stack.push(pushed[left++]);
               }
               left++;
           }
       } 

       return stack.isEmpty();
    }
}
