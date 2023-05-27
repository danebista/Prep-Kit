class Solution {
    Integer[][] memo;
    
    public String stoneGameIII(int[] stoneValue) {
        memo = new Integer[stoneValue.length+1][2];
        int AliceBob = dfs(0, stoneValue, 0);
        if(AliceBob < 0)
            return "Bob";
        if(AliceBob > 0)
            return "Alice";
        return "Tie";
    }
    
    int dfs(int index, int[] stone, int turn){
        if(index == stone.length)
            return 0;
        
        if(memo[index][turn] != null)
            return memo[index][turn];
        
        if(turn == 0){
            int next = index;
            int max = Integer.MIN_VALUE;
            int diff = 0;
            for(int i = 0; i < 3; i++){
                if(next == stone.length)
                    break;
                diff += stone[next++];
                max = Math.max(max, diff + dfs(next, stone, 1));
            }
            memo[index][0] = max;
            return max;
            
        } else {
            int next = index;
            int min = Integer.MAX_VALUE;
            int diff = 0;
            for(int i = 0; i < 3; i++){
                if(next == stone.length)
                    break;
                diff -= stone[next++];
                min = Math.min(min, diff + dfs(next, stone, 0));
            }
            memo[index][1] = min;
            return min;
        }
    }
}
