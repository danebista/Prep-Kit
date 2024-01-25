class Solution {
    public boolean cAC(String mS,String sS) {
        int[] cC= new int[256]; 
        for (char c : mS.toCharArray()) {
            cC[c]++;
        }
        for (char c : sS.toCharArray()) {
            cC[c]--;
        }
        for (int count : cC) {
            if (count < 0) {
                return false;
            }
        }
        
        return true;
    }
    public int countCharacters(String[] arr, String chars) {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(cAC(chars,arr[i])){
                count+=arr[i].length();
                System.out.println(arr[i]);
            }
        }
        return count;
    }
}