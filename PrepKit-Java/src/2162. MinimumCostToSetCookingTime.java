class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minutes = targetSeconds/60;
        int seconds = targetSeconds % 60;
        List<Integer> time1 = helper(minutes, seconds);
        List<Integer> time2 = helper(minutes-1, seconds+60);
        return Math.min(calculate(startAt, moveCost, pushCost, time1), 
        calculate(startAt, moveCost, pushCost, time2));
    }

    public List<Integer> helper(int minutes, int seconds){
        if (minutes>=100 || seconds>=100) return null;
        List<Integer> result = new ArrayList<>();
        result.add(minutes/10);
        result.add(minutes%10);
        result.add(seconds/10);
        result.add(seconds%10);

        return result;
    }

       public int calculate(int startAt,int moveCost, int pushCost, List<Integer> time){
        if(time==null) return Integer.MAX_VALUE;
        int cost=0,index=0;
        while(time.get(index)==0) index++; //Always skip starting zeros even if you are at zero as they cost pushCost
        int currentPosition = startAt;
        while(index<=3){
            if(currentPosition==time.get(index)) cost+=pushCost;
            else{
                currentPosition=time.get(index);
                cost+=pushCost+moveCost;
            }
            index++;
        }
        return cost;
    }
}
