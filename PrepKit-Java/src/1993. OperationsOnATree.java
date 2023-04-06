class LockingTree {
    HashMap<Integer, List<Integer>> up;
    HashMap<Integer, List<Integer>> down;
    HashMap<Integer, Integer> locked;
    
    public LockingTree(int[] parent) {
        up = new HashMap<>();
        down=new HashMap<>();
        locked=new HashMap<>();
        for (int i=0; i< parent.length; i++){
            if (!up.containsKey(i)) up.put(i, new ArrayList<>());
            if (!down.containsKey(i)) down.put(i, new ArrayList<>());
            locked.put(i, -1);
        }

        for (int i=0; i< parent.length; i++){
            if (i!=0){
                up.get(i).add(parent[i]);
                down.get(parent[i]).add(i);
            }
          
        }

    }
    
    public boolean lock(int num, int user) {
        if (locked.get(num)!=-1) return false;
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if (locked.get(num)!=user) return false;
        locked.put(num, -1);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if (locked.get(num)!=-1) return false;
        boolean checkDec = checkDec(num);
        boolean checkInc = checkAnc(num);
        
        if (checkDec && checkInc){
            unlockDec(num);
            locked.put(num, user);
            return true;
        }
       
        return false;
    }

    public void unlockDec(int num){
        for (Integer child: down.get(num)){
            locked.put(child, -1);
            unlockDec(child);
        }
    }

    public boolean checkDec(int num){
        boolean flag = locked.get(num)!=-1;

        for (Integer child: down.get(num)){
            flag= flag | checkDec(child);
        }

        return flag;
    }

    public boolean checkAnc(int num){
       boolean flag = locked.get(num)==-1;
       for (Integer child: up.get(num)){
           flag = flag & checkAnc(child);
       }

       return flag;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
