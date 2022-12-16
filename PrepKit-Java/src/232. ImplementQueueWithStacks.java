class MyQueue {
    Stack<Integer> stack = new Stack();
    Stack<Integer> stack2 = new Stack();
    int top;

    public MyQueue() {
        stack = new Stack();
        stack2 = new Stack();
        top = -1;
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        stack.push(x);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
