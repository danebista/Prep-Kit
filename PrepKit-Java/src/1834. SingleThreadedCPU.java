class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->a.etime-b.etime);
        PriorityQueue<Task> orderPq = new PriorityQueue<>((a,b)-> a.ptime==b.ptime? a.index-b.index: a.ptime-b.ptime);
        int[]res = new int[tasks.length];
        int index =0;
    
        for (int i=0; i< tasks.length; i++){
            pq.offer(new Task(i, tasks[i][0], tasks[i][1]));    
        }
        
        int current = pq.peek().etime;


        while (!pq.isEmpty() || !orderPq.isEmpty()){
            while (!pq.isEmpty() && pq.peek().etime <= current){
                orderPq.offer(pq.poll());
            }
            if (!orderPq.isEmpty()){
                Task give = orderPq.poll();
                current = current+ give.ptime;
                res[index++] = give.index;
            }
            else{
                current = pq.peek().etime;
            }
        }  

        return res;
    }

    class Task{
        int index;
        int etime;
        int ptime;

        Task(int index, int etime, int ptime){
            this.index = index;
            this.etime = etime;
            this.ptime = ptime;
        }
    }
}
