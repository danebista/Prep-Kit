    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            // Count the number of occurrences of each unique integer in the input array.
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            int uniqueIntegers = countMap.size();
            // Use a PriorityQueue to sort the map entries based on values (counts).
            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            minHeap.addAll(countMap.entrySet());

            // Remove elements from the minHeap to meet the constraint.
            while (!minHeap.isEmpty() && k > 0) {
                Map.Entry<Integer, Integer> entry = minHeap.poll();
                int count = entry.getValue();
                
                if (count <= k) {
                    // If there are more occurrences than k, remove the entire element.
                    uniqueIntegers--;
                    k -= count;
                } else {
                    // If k is less than the current count, set count to the number of remaining unique integers and break the loop.
                    break;
                }
            }

            return uniqueIntegers;
        }
    }
    