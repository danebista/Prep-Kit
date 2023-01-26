//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        return helper(s);
        
        
    }
    String helper(String s){
        StringBuilder res = new StringBuilder();
        int index=0;
        if (s.length()==1) return s;
       while (index < s.length()){
        if (index+1< s.length() && s.charAt(index)!=s.charAt(index+1)){
            res.append(s.charAt(index));
        }
        else{
             while (index+1< s.length() && index< s.length() && s.charAt(index)==s.charAt(index+1)){
                 index++;
                    
             }
         }
         index++;
         if (index==s.length()-1){
             res.append(s.charAt(index));
         }
        };
        if (res.length() == s.length()) return res.toString();
    
        return helper(res.toString());
    }
}
    