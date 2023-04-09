class Solution {
    public boolean stoneGame(int[] piles) {
        HashMap<String, Boolean> hashmap=new HashMap<>();
        return canWin(piles,0, piles.length-1, 0, 0,0, hashmap);

    }
    public boolean canWin(int[]piles,int start,int end, int flag, int alice, int bob, HashMap<String, Boolean> hashmap){
            if (start>end){
                if (alice> bob)return true;
                else return false;
            }
            String key = start+"i"+end+"j"+flag;
            if (hashmap.containsKey(key))return hashmap.get(key);           
            int nextFlag=0==flag?1:0;
            boolean win = false;
            boolean win2 = false;
            
            if (flag==0){
                win = canWin(piles, start+1, end,1,alice+=piles[start], bob, hashmap);
                
                win2 = canWin(piles, start, end-1,1,alice+=piles[end], bob, hashmap);
            }
            else{
                win = canWin(piles, start+1, end,0,alice, bob+=piles[start], hashmap);
                win2 = canWin(piles, start, end-1,0,alice, bob+=piles[end], hashmap);
            }
             //if I play optimally, I will always play the moves that make me win,
            //hence I can do this.
            // different then nim game in the ssense that in nim game I don't exactly know which move is for which player because we don't save player state,but here we are saving player state, hence I will always play the move that makes me win.
            if (win){
                hashmap.put(key, true);
                return true;
            }
            if (win2){
                hashmap.put(key, true);
                return true;
            }
           
           
            hashmap.put(key, false);
            return false;
    }
}
