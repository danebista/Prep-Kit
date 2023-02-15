class Solution {

    Map<Integer, Integer> map;
    int rows, cols, total;
    
    public Solution(int n_rows, int n_cols) {
        map = new HashMap<>();
       
        rows = n_rows; 
        cols = n_cols; 
        total = rows * cols;
    }
    
    public int[] flip() {
        int r =(int) Math.floor(Math.random()* total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }
    
    public void reset() {
        map.clear();
        total = rows * cols;
    }
}


