class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int[]arr = new int[words.length];
        HashSet<Character> hashset = new HashSet<>();
        Collections.addAll(hashset, 'a','e','i','o','u');
        
        for (int i=0; i< words.length; i++){
            int length = words[i].length();
            if (hashset.contains(words[i].charAt(0)) && hashset.contains(words[i].charAt(length-1))){
                if (i==0){
                    arr[i]=1;
                }
                else{
                arr[i]=arr[i-1]+1;
                }
            }
            else{
                if (i==0) continue;
                arr[i]=arr[i-1];
            }
        }

        int res = left-1>=0? arr[right]-arr[left-1]: arr[right];
        
        return res;
    }
}
