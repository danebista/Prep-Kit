class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] counter = new int[26];
        for (int i=0; i<p.length();i++){
            char c=p.charAt(i);
            counter[c-'a']+=1;
        }
        
        int lpoi=0;
        int rpoi=p.length();
        List<Integer> result = new ArrayList<>();

        while (rpoi<=s.length()){
            String temp = s.substring(lpoi, rpoi);

            if (isAnagram(temp, counter)) result.add(lpoi);
            lpoi++;
            rpoi++;
        }

        return result;
    }

    public boolean isAnagram(String temp, int[] counter){
        int[] tempArr = new int[26];
        for (char c: temp.toCharArray()){
            tempArr[c-'a']+=1;
        }

        for (int i=0; i<26; i++){
            if (counter[i]!=tempArr[i]) return false;
        }
        return true;
    }
}
