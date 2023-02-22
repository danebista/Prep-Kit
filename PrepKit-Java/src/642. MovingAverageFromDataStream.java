public class MovingAverage {
    Queue<Integer> queue;
    int count;
    int sum;
    int size;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
         queue= new LinkedList<>();
         count = 0;
         sum = 0;
         this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        count++;
        queue.offer(val);
        int value = 0;
        if (count>size){
            value = queue.poll();
        }
    
        sum+=val-value;
        int divider = Math.min(count, size);
        double ans = sum*1.0/divider;
        return ans;
    }
}
