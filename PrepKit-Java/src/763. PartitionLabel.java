class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            Character val = s.charAt(i);
            hashmap.put(val, i);
        }
        List<Integer> result = new ArrayList<>();
        int maxVal=0;
        int prev=-1;
        for (int i=0; i<s.length(); i++){
            maxVal= Math.max(maxVal, hashmap.get(s.charAt(i)));
            if (i==maxVal){
                result.add(maxVal-prev);
                prev=maxVal;
            }
        }

        return result;
    }
}