class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] arrays  = new Pair[speed.length];
        
        for (int i=0; i< speed.length; i++){
            Pair curr = new Pair(position[i], speed[i]);
            arrays[i]=curr;
        }

        Arrays.sort(arrays, (a,b)->(a.position-b.position));
        int fleet=0;
        double maximum=Double.MIN_VALUE;
        for (int i=arrays.length-1; i>=0; i--){
            double currSpeed=1.0*(target-arrays[i].position)/arrays[i].speed;
            if (currSpeed> maximum){
                fleet++;
                maximum=currSpeed;
            }
        }
        return fleet;

    }

    class Pair{
        int position;
        int speed;
        Pair(int pos, int speed){
            this.position = pos;
            this.speed=speed;
        }
    }
}
