class Solution {
    public String makeLargestSpecial(String s) {
        List<String> result = new ArrayList();
        int count =0;
        int l_poi=0;
 
        for (int i=0; i< s.length(); i++){
            if (s.charAt(i)=='1'){
                count++;
            }
            else{
                count--;
            }
            if (count==0){
                String val = "1"+makeLargestSpecial(s.substring(l_poi+1, i))
                    +"0";
                l_poi=i+1;
                count=0;
                
                result.add(val);
            }
        }
        if (result.size()==0) return "";
        Collections.sort(result, Collections.reverseOrder());
        
        return String.join("", result);
    }
}
