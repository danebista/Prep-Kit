class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int[] match : matches) {
            if (!hashmap.containsKey(match[0])) {
                hashmap.put(match[0], 0);
            }
            hashmap.put(match[1], hashmap.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> result0 = new ArrayList<>();

        List<Integer> result1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> val : hashmap.entrySet()) {
            int key = val.getKey();

            int value = val.getValue();
            if (value == 1) {
                result1.add(key);
            }
            if (value == 0) {
                result0.add(key);
            }
        }

        Collections.sort(result0);
        Collections.sort(result1);
        List<List<Integer>> newVal = new ArrayList<>();
        newVal.add(result0);
        newVal.add(result1);

        return newVal;
    }
}

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] result0 = new int[100001];
        Arrays.fill(result0, -1);

        for (int[] match : matches) {
            if (result0[match[0]] == -1) {
                result0[match[0]] = 0;
            }

            if (result0[match[1]] == -1 || result0[match[1]] == 0) {
                result0[match[1]] = 1;
            } else if (result0[match[1]] >= 1) {
                result0[match[1]] += 1;
            }
        }

        List<Integer> result2 = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        for (int i = 0; i < result0.length; i++) {
            if (result0[i] == 0) {
                result2.add(i);
            } else if (result0[i] == 1) {
                result1.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(result2);
        res.add(result1);
        return res;
    }
}
