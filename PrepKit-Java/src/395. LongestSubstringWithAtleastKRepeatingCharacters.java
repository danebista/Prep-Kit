class Solution {
    public int longestSubstring(String s, int k) {
       return helper(s, k, 0, s.length()-1);
    }
    

    public int helper(String s, int k, int start, int end){
        if (start>end) return 0;
        if (end-start+1<k) return 0;
        
        int[] count = new int[26];
        for (int i=start; i<=end; i++){
            count[s.charAt(i)-'a']++;
        }
        int max=0;
        for (int i=start; i<=end; i++){
            if (count[s.charAt(i)-'a']<k){
                
                int left = helper(s, k, start, i-1);
                int right= helper(s,k, i+1, end);
                max = Math.max(left, right);
                return max;
            }
        }

        return end-start+1;
    }
    
}
