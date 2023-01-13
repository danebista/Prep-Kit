class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance=0;
        int payable = 0;
        int index=0;
        for (int i=0; i< gas.length; i++){
            if (cost[i]> (gas[i]+balance)){
                payable+= -(cost[i]-(gas[i]+balance));
                index=i+1;
                balance=0;
            }
            else{
                balance += gas[i]-cost[i];
            }
        }
        return balance+payable>=0? index: -1;
        
    }
}
