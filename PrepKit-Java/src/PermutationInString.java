class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // generate anagrams of same window size and see if equal
        // use array/hashmap to see if the size of both are equal
        // use match variable to match each of them and check

        if (s1.length()> s2.length()) return false;
        int[] count = new int[26];
        int[]temp =new int[26];

        for (int i=0; i< s1.length(); i++){
            count[s1.charAt(i)-'a']+=1;
            temp[s2.charAt(i)-'a']+=1;
        }
        int counts=0;
        
        for (int i=0; i<26; i++){
            if (count[i]==temp[i])counts++;
        }

        if (counts==26) return true;

        int low=0;
        int high=s1.length();
        
        while (high< s2.length()){
            temp[s2.charAt(high)-'a']+=1;
            temp[s2.charAt(low)-'a']-=1;
            int countC=0;
            for (int i=0; i<26; i++){
                if (count[i]==temp[i])countC++;
            }
            if (countC==26) return true;
            low++;
            high++;
        }

        return false;
    }
}
