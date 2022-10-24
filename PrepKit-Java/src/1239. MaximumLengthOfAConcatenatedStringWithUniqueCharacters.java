class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, "", 0);
    }

    public int helper(List<String> arr, String current, int index) {
        HashSet<Character> result = new HashSet<>();
        for (Character c : current.toCharArray()) {
            if (!result.add(c))
                return 0;
        }
        int max = current.length();
        for (int i = index; i < arr.size(); i++) {
            max = Math.max(max, helper(arr, current + arr.get(i), i + 1));
        }

        return max;
    }
}

class Solution {
    public int maxLength(List<String> arr) {
        HashMap<String, Integer> unique = new HashMap<>();
        return  helper(arr, "", 0);
        
    }
    public int helper(List<String> arr, String current, int index){
        HashSet<Character> result = new HashSet<>();
     
      
        if (index >=arr.size()){
           return 0;
        }
        
        String dummy = current+ arr.get(index);
        boolean take = true;  
        for (Character c: dummy.toCharArray()){
            if (!result.add(c)) {
                 take = false;
            }
        }
        
        int takes =0;
        if (take){
               takes = arr.get(index).length() + helper(arr, current+arr.get(index), index+1);   
        }
        int notTake = 0 + helper(arr, current, index+1);
        
        return Math.max(takes, notTake);
    }
}