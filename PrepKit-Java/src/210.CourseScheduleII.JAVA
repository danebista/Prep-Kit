

class Solution {
    HashMap<Integer, List<Integer>> hashmap;
    HashSet<Integer> visited;
    List<Integer> ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        hashmap  = new HashMap();
        visited = new HashSet();
      
        ans = new ArrayList();
        
        for (int i=0; i<numCourses; i++){
            hashmap.put(i, new ArrayList());
        }
        
        for (int[] preq: prerequisites){
            hashmap.get(preq[0]).add(preq[1]);
        }
        
        for (int i=0; i<numCourses; i++){
            if (!helper(i)) return new int[]{};
        }
        
        int[] result = new int[ans.size()];
        int count =0;
        for (Integer inte: ans){
            result[count] =inte;
            count++;
        }
      
        return result;
        
    }
    
    public boolean helper(int root){
        if (visited.contains(root)) return false;
        if (ans.contains(root)) return true;
        
        visited.add(root);
        
        for (int value: hashmap.get(root)){
            if (!helper(value)) return false;
        }
        
        ans.add(root);
        visited.remove(root);
        return true;
    }
}
