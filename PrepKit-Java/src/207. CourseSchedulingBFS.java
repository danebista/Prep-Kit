class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap();

        for (int i = 0; i < numCourses; i++) {
            hashmap.put(i, new ArrayList());
        }
        int[] indegree = new int[numCourses];

        for (int[] preq : prerequisites) {
            hashmap.get(preq[0]).add(preq[1]);
            indegree[preq[1]]++;
        }
        List<Integer> order = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (Integer i : hashmap.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    queue.offer(i);
            }
        }

        if (count == numCourses)
            return true;
        else
            return false;

    }

}
