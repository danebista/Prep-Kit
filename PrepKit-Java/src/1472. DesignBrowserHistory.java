class BrowserHistory {
    DoublyLinkedlist curr;
    public BrowserHistory(String homepage) {
    
        curr= new DoublyLinkedlist(homepage);
    }
    
    public void visit(String url) {
        
        curr.next = new DoublyLinkedlist(url);
        curr.next.prev = curr;
        curr=curr.next;
        
    }
    
    public String back(int steps) {
       
        while (steps>0 && curr.prev!=null){

            if (steps==6){
                System.out.println(curr.prev.val);
            }
            steps-=1;
           
            curr=curr.prev;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while (steps!=0 && curr.next!=null){
            steps-=1;
            curr=curr.next;
        }
        return curr.val;
    }
}

class DoublyLinkedlist{
    String val; 
    DoublyLinkedlist prev;
    DoublyLinkedlist next;
    public DoublyLinkedlist(String val){
        this.val = val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
