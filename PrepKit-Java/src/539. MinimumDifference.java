class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> result = new ArrayList<>();
        for (String s: timePoints){
            int val = Integer.valueOf(s.substring(0,2))*60;
            int valSec = val+Integer.valueOf(s.substring(3,5));

            result.add(valSec);
        }

        Collections.sort(result);
        int minVal = Integer.MAX_VALUE;
        
        for (int i=1; i< result.size(); i++){
            if (result.get(i)-result.get(i-1) < minVal){
                minVal= result.get(i)-result.get(i-1);
            }
        }

        if ((24*60-(result.get(result.size()-1)-result.get(0)))< minVal){
            minVal = 24*60-result.get(result.size()-1)+result.get(0);
        }

        return minVal;
    }
}
