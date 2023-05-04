class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> hashset;
    public SmallestInfiniteSet() {
        pq=new PriorityQueue<>();
        hashset = new HashSet<>();
        
        for (int i=1; i<=1000; i++){
            pq.offer(i);
            hashset.add(i);
        }

        
    }
    
    public int popSmallest() {
        int smallest = pq.poll();
        hashset.remove(smallest);

        return smallest;
    }
    
    public void addBack(int num) {
        if (!hashset.contains(num)){
            hashset.add(num);
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */