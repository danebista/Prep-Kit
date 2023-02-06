class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] wordIndex = new int[26];

        for (int i=0; i< order.length(); i++){
            char c = order.charAt(i);
            wordIndex[c-'a'] = i;
        }

        for (int i=1; i< words.length; i++){
            if (isBigger(words[i], words[i-1], wordIndex)) return false;
        }

        return true;
    }

    public boolean isBigger(String a, String b, int[] wordIndex){
        
        for (int i=0; i< Math.min(a.length(), b.length()); i++){
            if (a.charAt(i) != b.charAt(i)){
                return  wordIndex[b.charAt(i)-'a'] > wordIndex[a.charAt(i)-'a']; 
            } 
        }
        return a.length()<b.length();
    }
}

