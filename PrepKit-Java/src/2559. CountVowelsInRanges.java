class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        //HashSet<Integer> hashset= new HashSet<>();
        HashSet<Character> alpha = new HashSet<>();
        alpha.add('a');
        alpha.add('e');
        alpha.add('i');
        alpha.add('o');
        alpha.add('u');
        int[]prefix = new int[words.length];
        
        for (int i=0; i<words.length; i++){
            String s = words[i];
            if (alpha.contains(s.charAt(0)) && alpha.contains(s.charAt(s.length()-1))){
                prefix[i]=1;
            } 
            if (i>0) prefix[i]+=prefix[i-1];
        }
        int[]res= new int[queries.length];
        
        for (int i=0; i< queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if (left>0){
                res[i] = prefix[right]-prefix[left-1];
            }
            
            else 
                res[i]=prefix[right];
        }
        
        return res;
    }
}
