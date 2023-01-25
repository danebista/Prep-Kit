public class 93. RestoreIPAddresses {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            helper(result, s, 4, new StringBuilder());
            return result;
        }
    
        public void helper(List<String> result, String s, int zones, StringBuilder sb){
            if (s.length()==0 && zones==0){
                result.add(sb.substring(0, sb.length()-1).toString());
                return;
            }
    
            if (s.length()>0 && zones==0){
                return;
            }
    
            if (zones>0 && s.length()==0){
                return;
            }
    
            int minimum = Math.min(3, s.length());
            StringBuilder sbs = new StringBuilder();
    
            for (int i=0; i< minimum; i++){
               sbs.append(s.charAt(i));
               int value = Integer.parseInt(sbs.toString());
               if (sbs.length()==2 && value<10) continue;
               if (sbs.length()==3 && (value> 255 || value<100)) continue;
               StringBuilder temp = new StringBuilder(sb);
               sb.append(sbs.toString()).append(".");
               helper(result,  s.substring(i+1, s.length()), zones-1, sb);
               sb = temp;
            }
        }
    }
}
