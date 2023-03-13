class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[]dp = new long[n+1];
    
    
        Arrays.fill(dp,-1);

        HashMap<Integer, List<Pair>> hashmap = new HashMap<>();

        for (int i=0; i<rides.length; i++){
            Pair curr = new Pair(rides[i][0], rides[i][1], rides[i][2]);

            if (!hashmap.containsKey(rides[i][0])){
                hashmap.put(rides[i][0], new ArrayList<>());
            }
            hashmap.get(rides[i][0]).add(curr);
        }
       
        return helper(1, n, rides, dp, hashmap);

    }

    class Pair{
        int start;
        int end;
        int tip;
        Pair(int start, int end, int tip){
            this.start = start;
            this.end = end;
            this.tip = tip;
        }
    }

    public long helper(int index, int n, int[][]rides, long[] dp , HashMap<Integer, List<Pair>> hashmap){
        if (index>n){
            return 0;
        }
        if (dp[index]!=-1) return dp[index];
        long nottake = helper(index+1, n, rides, dp, hashmap);
     
        if (hashmap.get(index)==null){
           return dp[index]=nottake;
        }

        long take = Long.MIN_VALUE;
        for (Pair temp: hashmap.get(index)){
            take = Math.max(take, temp.end-temp.start+temp.tip+ helper(temp.end, n, rides, dp, hashmap));
        }

        return dp[index]=Math.max(nottake, take);
    }
}