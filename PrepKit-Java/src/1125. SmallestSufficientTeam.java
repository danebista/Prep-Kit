class Solution {
    List<Integer> minimum = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        int i=0;
        for (String s: req_skills){
            hashmap.put(s,i++);
        }

        int[] bitMasks = new int[people.size()];
        for (int k=0; k< people.size();k++){
            int bitM = 0;
            for (int j=0; j< people.get(k).size(); j++){
                int currBit = 1<< hashmap.get(people.get(k).get(j));
                bitM |= currBit;
            }
            bitMasks[k]= bitM;
        }
        int n = req_skills.length;
          int[][] dp = new int[people.size()][1<<n];
        for(int[] row:dp)Arrays.fill(row, -1);

        helper(0, bitMasks, 0, new ArrayList<>(), n,dp);

        int[] ans = new int[minimum.size()];
        for(int t=0; t<minimum.size(); t++){
            ans[t] = minimum.get(t);
        }

        return ans;

    }

    public void helper(int j, int[]bitMasks, int currBit, List<Integer> current, int n, int[][] dp){
        if (j==bitMasks.length){
            if (currBit==(1<<n)-1){
                if (minimum.size()==0 || current.size()< minimum.size()){
                    minimum = new ArrayList<>(current);
                }
            }
            return;
        }
        if(dp[j][currBit]!=-1 && dp[j][currBit]<=current.size())
        return;


        helper(j+1, bitMasks, currBit, current, n, dp);
        current.add(j);
        helper(j+1, bitMasks, currBit|bitMasks[j], current,n, dp);
        current.remove(current.size()-1);

        if(current.size() > 0) dp[j][currBit] = current.size();
    }
}

