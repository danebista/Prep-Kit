class RandomizedCollection {
    HashMap<Integer, List<Integer>> hashmap;
    List<Integer> list;
    java.util.Random rand = new java.util.Random();
    public RandomizedCollection() {
        hashmap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (hashmap.containsKey(val)){
            List<Integer> curr = hashmap.get(val);
            curr.add(list.size());
            list.add(val);
            
            return false;
        }    
        else{
            hashmap.put(val, new ArrayList());
            hashmap.get(val).add(list.size());
        }
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!hashmap.containsKey(val)) return false;
        List<Integer> indices = hashmap.get(val);
        int currentIndex= indices.get(indices.size()-1);
        hashmap.get(val).remove(indices.size()-1);
        
        
        if (currentIndex< list.size()-1){
            int value = list.get(list.size()-1);
            list.set(currentIndex, value);
            hashmap.get(value).remove(hashmap.get(value).size()-1);
            hashmap.get(value).add(currentIndex);
            /* Remember to sort here*/Collections.sort(hashmap.get(value));
        }  
        list.remove(list.size()-1);
      
        if (hashmap.get(val).size()==0) hashmap.remove(val);
    
        return true;
    }
    
    public int getRandom() {
        
        return list.get( rand.nextInt(list.size()) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */