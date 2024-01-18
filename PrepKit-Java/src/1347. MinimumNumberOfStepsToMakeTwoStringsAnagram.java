class Solution {
    public int minSteps(String s, String t) {
        int[] sValue = new int[26];
        int[] tValue = new int[26];

        for (int i=0; i< s.length(); i++){
            sValue[s.charAt(i)-'a']++;
            tValue[t.charAt(i)-'a']++;
        }
        
        int count=0;
        for (int i=0; i<26; i++){
            if (sValue[i]-tValue[i]>0){
                count+= sValue[i]-tValue[i];
            }
        }

        return count;
    }
}
