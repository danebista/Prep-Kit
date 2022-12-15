class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap();

        for (int i = 0; i < numCourses; i++) {
            hashmap.put(i, new ArrayList());
        }

        for (int[] preq : prerequisites) {
            hashmap.get(preq[0]).add(preq[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] currentPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!visit(i, visited, currentPath, hashmap))
                    return false;
            }
        }
        return true;

    }

    public boolean visit(int numCourse, boolean[] visited, boolean[] currentPath,
            HashMap<Integer, List<Integer>> hashmap) {
        visited[numCourse] = true;
        currentPath[numCourse] = true;

        for (Integer i : hashmap.get(numCourse)) {
            if (!visited[i] && !visit(i, visited, currentPath, hashmap))
                return false;
            else if (currentPath[i])
                return false;
        }

        currentPath[numCourse] = false;
        return true;
    }

}
