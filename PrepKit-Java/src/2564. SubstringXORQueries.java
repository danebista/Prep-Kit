class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
       HashMap<Integer, int[]> hashmap = new HashMap<>();
       for (int i=0; i< s.length(); i++){
           if (s.charAt(i)=='1'){
               int v=0;
               for (int j=i; j< Math.min(s.length(), i+32); j++){
                    v=v*2;
                    if (s.charAt(j)=='1'){
                        ++v;
                    }
                    if (!hashmap.containsKey(v)) hashmap.put(v, new int[]{i,j});
                 }
           }
           else {
               if (!hashmap.containsKey(0)) hashmap.put(0, new int[]{i,i});
           }
       }
       
       int[][] result = new int[queries.length][2];
       int i=0;
       for (int[] query: queries){
           int val = query[0] ^ query[1];
           if (hashmap.containsKey(val)){
               int[] results = hashmap.get(val);
               result[i][0]=results[0];
               result[i][1]=results[1];
           }
           else{
               result[i][0]=-1;
               result[i][1]=-1;
           }
           i++;
       }

       return result;
    }
}
