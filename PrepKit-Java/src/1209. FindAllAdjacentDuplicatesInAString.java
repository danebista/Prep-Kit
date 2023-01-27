class Solution {

    class Pair{
        char c;
        int count;
        Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        int i=0;
        while (i< s.length()){
            if (stack.isEmpty()){
                stack.push(new Pair(s.charAt(i), 1));
            }
            else {
                if (stack.peek().c==s.charAt(i)){
                    stack.peek().count++;
                    if (stack.peek().count==k) stack.pop();
                }
                else{
                    stack.push(new Pair(s.charAt(i), 1));
                }
            }
            i++;
        }
        Stack<Pair> temp = new Stack<>();
        while (!stack.isEmpty()){
          temp.push(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!temp.isEmpty()){
            Pair curr = temp.pop();
            StringBuilder holder = new StringBuilder();
            int no = curr.count;
            while (no >0){
               holder.append(curr.c);
               no--;
            }

            result.append(holder.toString());
        }

        return result.toString();

    }
}
