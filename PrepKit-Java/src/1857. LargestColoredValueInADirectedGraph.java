class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int[]colorStr=new int[26];
        
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        
        for (int i=0; i< colors.length(); i++){
            hashmap.put(i, new ArrayList<>());
        }

        boolean[] visited= new boolean[colors.length()];
        boolean[] currentPath = new boolean[colors.length()];
        HashMap<Integer, int[]> count = new HashMap<>();

        for (int[] edge: edges){
            hashmap.get(edge[0]).add(edge[1]);
        }
        
        int max=-1;

        for (int i=0; i< colors.length(); i++){
            if (!visited[i]){
                int[]values = helper(colors, i, hashmap, visited, currentPath, colorStr, count);
                if (values.length==1 && values[0]==-1) return -1;
                for (int j=0; j<26; j++){
                     max=Math.max(max, values[j]);
                }
            }
        }

        return max;
    }

    public int[] helper(String colors, int i, HashMap<Integer, List<Integer>> hashmap, 
    boolean[] visited, boolean[] currentPath, int[]colorStr, HashMap<Integer, int[]> count){
      
        if (currentPath[i]) return new int[]{-1} ;
        if (visited[i]){
            return count.get(i);
        }
        int[] values = new int[26];
        
        currentPath[i]= true;
        
        for (Integer val: hashmap.get(i)){
            int[]vals=helper(colors, val, hashmap, visited, currentPath, colorStr, count);
            if (vals.length==1 && vals[0]==-1) return new int[]{-1};
             
            for (int m=0; m< 26; m++){
                values[m]=Math.max(values[m],vals[m]);
              
            }

        }
        
        values[colors.charAt(i)-'a']++;
        currentPath[i] = false;
        visited[i] = true;

       
        count.put(i, values);
        return values;
    } 
}

