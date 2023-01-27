class DetectSquares {
    List<Pair> result;
    HashMap<String, Integer> hashmap;
    public DetectSquares() {
    result = new ArrayList<>();
    hashmap = new HashMap<>();
    }
    
    public void add(int[] point) {
        Pair newPair = new Pair(point[0], point[1]);

        result.add(newPair);
        String val =point[0]+ "i"+ point[1]+"j";
        hashmap.put(val, hashmap.getOrDefault(val,0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        for (int i=0; i<result.size(); i++){
            Pair curr = result.get(i);
            if (Math.abs(curr.x-point[0]) != Math.abs(curr.y-point[1]) || curr.x==point[0] || curr.y==point[1])     continue;
            String key1 = curr.x + "i"+ point[1]+"j";
            String key2 = point[0]+"i"+ curr.y+"j";
            if (hashmap.containsKey(key1) && hashmap.containsKey(key2)){
                res+= hashmap.get(key1) * hashmap.get(key2);
            }
        }
        return res;
    }
    class Pair{
        int x; 
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}


