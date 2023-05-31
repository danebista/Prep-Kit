class UndergroundSystem {
    HashMap<Integer, Pair> hashmap;
    HashMap<String, int[]> current;
    public UndergroundSystem() {
        hashmap = new HashMap<>();
        current = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair newPair = new Pair(stationName, t);
        hashmap.put(id, newPair);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair currentPair = hashmap.get(id);
        String key = stationName + "-" + currentPair.station;
        if (current.containsKey(key)){
            int[] values = current.get(key);
            values[0] += t - currentPair.t;
            values[1] +=1;
        }
        else {
            int[]values = new int[2];
            values[0]= t-currentPair.t;
            values[1]=1;
            current.put(key, values);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = endStation+"-"+startStation;
        int[] value = current.get(key);

        double values = (double) value[0]/value[1];
        return values;
    }

    class Pair {
        String station;
        int t;
        Pair(String stationName, int t){
            this.station= stationName;
            this.t=t;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
