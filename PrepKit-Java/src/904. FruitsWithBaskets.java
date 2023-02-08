class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int r=0; 
        int l=0;
        int max=Integer.MIN_VALUE;
        while (r<fruits.length){
            hashmap.put(fruits[r], hashmap.getOrDefault(fruits[r],0 )+1);
            while (hashmap.size()>2){
                hashmap.put(fruits[l], hashmap.get(fruits[l])-1);
                if (hashmap.get(fruits[l])==0){
                    hashmap.remove(fruits[l]);
                }
                l++;
            }
            max= Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
