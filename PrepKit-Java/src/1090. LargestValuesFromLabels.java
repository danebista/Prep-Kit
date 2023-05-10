class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Pair[] newValues = new Pair[values.length];

        for (int i=0; i< values.length; i++){
            newValues[i]=new Pair(values[i], labels[i]);
        }
        int value = 0;

        Arrays.sort(newValues, (a,b)->(b.value-a.value));
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i=0; i< newValues.length; i++){
            if (!hashmap.containsKey(newValues[i].label)){
                hashmap.put(newValues[i].label,0);
            }
            if (hashmap.get(newValues[i].label)>= useLimit) continue;
            value += newValues[i].value;
            hashmap.put(newValues[i].label, hashmap.get(newValues[i].label)+1);
            numWanted-=1;
            if (numWanted==0) return value;
        }
        
        return value;
        
    }

    class Pair{
        int value; 
        int label;

        Pair(int value, int label){
            this.value = value;
            this.label = label;
        }
    }
}
