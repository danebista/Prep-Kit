class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hashmap;

    public TimeMap() {
        hashmap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if (!hashmap.containsKey(key)) {
            TreeMap<Integer, String> treemap = new TreeMap();
            treemap.put(timestamp, value);
            hashmap.put(key, treemap);
        } else {
            hashmap.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        if (!hashmap.containsKey(key))
            return "";
        else if (hashmap.get(key).containsKey(timestamp)) {
            return hashmap.get(key).get(timestamp);
        }

        Integer preview = hashmap.get(key).floorKey(timestamp);
        if (preview == null)
            return "";

        return hashmap.get(key).get(preview);
    }
}
