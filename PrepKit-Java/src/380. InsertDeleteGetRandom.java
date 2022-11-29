class RandomizedSet {
    HashMap<Integer, Integer> hashmap;
    List<Integer> list;

    public RandomizedSet() {
        hashmap = new HashMap();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        if (hashmap.containsKey(val))
            return false;
        hashmap.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!hashmap.containsKey(val))
            return false;
        int currentIndex = hashmap.get(val);

        int lastValue = list.get(list.size() - 1);
        if (currentIndex < list.size() - 1) {
            list.set(currentIndex, lastValue);
            hashmap.put(lastValue, currentIndex);
        }
        list.remove(list.size() - 1);
        hashmap.remove(val);

        return true;
    }

    public int getRandom() {
        int max = list.size();
        int min = 0;
        int ind = (int) (Math.random() * (max - min) + min);
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */