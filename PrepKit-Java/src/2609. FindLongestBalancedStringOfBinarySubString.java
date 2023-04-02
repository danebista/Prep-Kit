class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int count0=0;
        int count1=0;
        int max=0;
        for (int i=0; i<s.length(); i++){
            if (i==0 && s.charAt(i)=='0'){
                count0++;
                continue;
            }
            else if (i==0 && s.charAt(i)=='1'){
                continue;
            }
            else if (s.charAt(i)==s.charAt(i-1) && s.charAt(i)=='0'){
                count0++;
                
            }
            else if (s.charAt(i)==s.charAt(i-1) && s.charAt(i)=='1'){
                count1++;
                
                
                max= Math.max(max, Math.min(count0, count1)*2);
            }
            else if (s.charAt(i-1)!=s.charAt(i) && s.charAt(i)=='1'){
                count1=1;
                max= Math.max(max, Math.min(count0, count1)*2);
            }
            else if (s.charAt(i-1)!=s.charAt(i) && s.charAt(i)=='0'){
                count0=1;
                count1=0;
            } 
        }
        
        return max;
    }
}
