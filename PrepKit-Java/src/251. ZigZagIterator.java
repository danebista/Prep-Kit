public class ZigzagIterator {
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector */

    Queue<Integer> vol1;
    Queue<Integer> vol2;
    boolean isSwitched;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vol1 = new LinkedList<>();
        this.vol2 = new LinkedList<>();
        // do intialization if necessary
        for (int i=0; i< v1.size(); i++){
            vol1.offer(v1.get(i));
        }
        for (int i=0; i<v2.size(); i++){
            vol2.offer(v2.get(i));
        }
        isSwitched = true;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (!hasNext()) return -1;

        if (isSwitched){
            isSwitched = !isSwitched;
            if (vol1.size()!=0) return vol1.poll();
            return vol2.poll();
        }
        else{
            isSwitched = !isSwitched;
            if (vol2.size()!=0) return vol2.poll();
            return vol1.poll();
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return (vol1.size()!=0 || vol2.size()!=0);
    }
}
