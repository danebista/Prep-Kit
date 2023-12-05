class Solution {
    public List<List<Integer>> groupThePeople(int[] a) {
        
        List<List<Integer>> arr= new ArrayList<>();
        int n=a.length;
        
        HashMap<Integer,List<Integer>> mp= new HashMap<>();
        
        for(int i=0;i<n;i++){ 
        
          if(!mp.containsKey(a[i])){ 
              
              mp.put(a[i],new ArrayList<>());
          }     
            
            mp.get(a[i]).add(i);
            
            if(mp.get(a[i]).size()==a[i]){ 
            
                arr.add(mp.get(a[i]));
                mp.remove(a[i]);
                
            }
            
            
            
        
        }
        
        
        return arr;
        
    }
}

