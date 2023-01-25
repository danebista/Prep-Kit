public class 997. FindTheTownJudge {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int [] outDegree = new int[n+1];
            int [] inDegree = new int[n+1];
    
            for (int i=0; i < trust.length; i++){
                inDegree[trust[i][0]]++;
                outDegree[trust[i][1]]++;
            }
    
            for (int i=1; i< n+1; i++){
                if (outDegree[i]== n-1 && inDegree[i]==0) return i;
            }
    
            return -1;
        }
    }
}
