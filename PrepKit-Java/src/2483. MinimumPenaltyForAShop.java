class Solution {
    public int bestClosingTime(String customers) {
        int totalY=0;
        
        for (char c: customers.toCharArray()){
            if (c=='Y') totalY++;
        }

        int nFound=0;
        int totalYFound=0;
        int ansFound=0;
        int maxAnsFound=Integer.MAX_VALUE;

        for (int i=0; i<=customers.length(); i++){
            int remainingDays = totalY - totalYFound;

            int tempMax = remainingDays+nFound;
            if (tempMax< maxAnsFound){
                maxAnsFound = tempMax;
                ansFound=i;
            }
            if (i< customers.length() && customers.charAt(i)=='N') nFound++;
            if (i< customers.length() && customers.charAt(i)=='Y') totalYFound++; 
        }

        return ansFound;
    }
}
