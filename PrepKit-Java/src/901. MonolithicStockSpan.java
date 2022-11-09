class StockPair {
    int price;
    int val;

    StockPair(int price, int val) {
        this.price = price;
        this.val = val;
    }
}

class StockSpanner {
    Stack<StockPair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int val = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            StockPair curr = stack.pop();
            val += curr.val;
        }

        stack.push(new StockPair(price, val));

        return val;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
