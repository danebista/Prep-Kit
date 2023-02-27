class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        boolean x = true;
        boolean y = true;
        for (int i=0; i<s1.length(); i++){
            x&= t1[i]<=t2[i];
            y&= t2[i]<=t1[i];
        }

        return x || y;
    }
}