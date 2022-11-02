public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;

        HashSet<String> wordBank = new HashSet();

        for (String s : bank) {
            wordBank.add(s);
        }
        if (!wordBank.contains(end))
            return -1;
        int levels = 0;
        char[] changer = new char[] { 'A', 'C', 'G', 'T' };
        HashSet<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(end))
                    return levels;
                for (int j = 0; j < curr.length(); j++) {
                    for (char c : changer) {
                        String newStr = curr.substring(0, j) + c + curr.substring(j + 1);

                        if (wordBank.contains(newStr) && !visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            levels++;
        }

        return -1;
    }
}
