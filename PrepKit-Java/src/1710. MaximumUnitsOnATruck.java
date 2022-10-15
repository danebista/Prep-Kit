class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[]a, int[]b){
                return (b[1] - a[1]);
            }
            
        });
        int currWeight = 0;
        int price=0;
        for (int[] box: boxTypes){
            if (currWeight + box[0]<=truckSize){
                price += box[0]* box[1];
                currWeight += box[0];    
            }
            else {
                price+= (truckSize-currWeight)* box[1];
                break;
            }
        }
        
        return price;
    }
}
