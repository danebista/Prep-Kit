public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    HashMap<Integer, Integer> hashmap = new HashMap<>();
    public void add(int number) {
        // write your code here
        hashmap.put(number, hashmap.getOrDefault(number, 0)+1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int val: hashmap.keySet()){
            if (val!=(value-val) && hashmap.containsKey(value-val)) return true;
            if (val==(value-val) && hashmap.containsKey(value-val)
            && hashmap.get(value-val)>1) return true;
        }

        return false;
    }
}

