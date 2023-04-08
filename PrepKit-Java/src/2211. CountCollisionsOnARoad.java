class Solution {
    public int countCollisions(String directions) {
        int count =0;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< directions.length(); i++){
            if (stack.isEmpty()){
                stack.push(directions.charAt(i));
            }
            else if (directions.charAt(i)=='L' && (stack.peek()=='R'
            || stack.peek()=='S')){
                if (stack.peek()=='R') count+=2;
                else count+=1;
                stack.pop();
                while (!stack.isEmpty()&& stack.peek()=='R'){
                  count+=1;
                  stack.pop();
                }
                stack.push('S');
            }
            else if (directions.charAt(i)=='S' && stack.peek()=='R'){
                count++;
                stack.pop();
                while (!stack.isEmpty()&& stack.peek()=='R'){
                  count+=1;
                  stack.pop();
                }
                stack.push('S');
            }
            else {
                stack.push(directions.charAt(i));
            }

        }
        
        return count;
    }
}
