class Solution {
    public int minSteps(String s, String t) {
        int[] sc=new int[26];
        int[] tc=new int[26];
        //To count the frequencies of each char of s and t separately 
        for(char ch:s.toCharArray()){
            sc[ch - 'a']++;
        }
        for(char ch:t.toCharArray()){
            tc[ch - 'a']++;
        }

        int steps=0;
        for(int i=0;i<26;i++){
            steps+=Math.abs(sc[i]-tc[i]);
        }
        return steps;
    }
}
