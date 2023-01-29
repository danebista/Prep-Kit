public class 461. HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int newNo = x^y;
            int count=0;
            while (newNo!=0){
                newNo = newNo & (newNo-1);
                count++;
            }
            return count;
        }
    }
    
    x = 0001
    y = 0100
    x^y = 0101
    Now just count number of ones
    
}
