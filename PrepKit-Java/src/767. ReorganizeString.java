class Solution {
    public String reorganizeString(String s) {

        PriorityQueue<Map.Entry<Character , Integer>> maxQue = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        HashMap< Character ,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
       
       for(Map.Entry<Character , Integer> entry : map.entrySet()){
           maxQue.add(entry);
       }

        String ans ="";
        Map.Entry<Character , Integer> prev = null;

        while(!maxQue.isEmpty()){
            Map.Entry<Character , Integer> curr = maxQue.remove();
            ans += curr.getKey();
            curr.setValue(curr.getValue() - 1);
            if( prev != null && prev.getValue() > 0 && prev.getKey() != curr.getKey()){
                maxQue.add(prev);
            }
            prev = curr;
        }

        return s.length() != ans.length() ? "" : ans;
        
    }
}
