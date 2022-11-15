class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hashset = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (hashset.contains(arr[i] * 2) || (arr[i] % 2 == 0 && hashset.contains(arr[i] / 2)))
                return true;
            hashset.add(arr[i]);
        }

        return false;
    }
}
