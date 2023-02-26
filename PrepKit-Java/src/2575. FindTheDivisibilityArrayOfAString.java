class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] value = new int[word.length()];
        int b=1;
        
    
        long currNo = 0;
        for (int i=0; i< word.length(); i++){
            char curr = word.charAt(i);
            // Use remainder as value
            currNo= (currNo*10+Character.getNumericValue(curr))%m;
            if (currNo==0) value[i]=1;
        }   
    
        
        return value;
        
    }
}

