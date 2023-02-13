class Solution {
    public int countOdds(int low, int high) {
        int val = high-low+1;
        if (val%2==0) return val/2;
        if (val%2==1 && high%2==1 && low%2==1) return val/2+1;
        return val/2;
    }
}