class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int ans: answers){
            hashmap.put(ans,hashmap.getOrDefault(ans,0)+1);
           
        }

        for (Integer val: hashmap.keySet()){
           
            
            if (val==0) count+= hashmap.get(val);

            else if (val+1< hashmap.get(val)){
               count+= hashmap.get(val)/(val+1) * (val+1);
               if (hashmap.get(val)% (val+1) !=0){
                   count+= val+1; 
               }
               
            }
            else {
                 System.out.println(val+"-"+hashmap.get(val));
                count+= val+1;
            }
        }
       
        return count;
    }
}
