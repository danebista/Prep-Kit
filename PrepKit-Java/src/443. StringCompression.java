class Solution {
    public int compress(char[] chars) {
        int index=0; 
        int count=0;
        for (int i=0; i< chars.length; i++){
            if (i==0 || (i< chars.length && chars[i]==chars[i-1])){
                count++;
            }
            else {
                chars[index++]=chars[i-1];
                if (count!=1){
                    char[] values = String.valueOf(count).toCharArray();
                    for (char val: values){
                        
                        chars[index++]=val;
                    }
                }
                count=1;
            }
        }

        chars[index++]= chars[chars.length-1];
        if (count!=1){
            char[] values = String.valueOf(count).toCharArray();
            for (char val: values){
                chars[index++]=val;
            }
        }

        return index;
    }
}
