class Solution {
    public int maxProduct(String[] words) {
        int[] bitMask = new int[words.length];
        for (int i=0; i< words.length; i++){
            bitMask[i]=0;
            for (int j=0; j< words[i].length(); j++){
                bitMask[i]|=1<<(words[i].charAt(j)-'a');
            }
        }
        int maxProduct = 0;
        for (int i=0; i< words.length; i++){
            for (int j=0; j< i; j++){
                if ((bitMask[i] & bitMask[j])==0
                && (words[i].length()* words[j].length() > maxProduct)){
                    maxProduct = words[i].length() * words[j].length();
                }
            }
        }
        return maxProduct;
    }
}
