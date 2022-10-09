import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> setMap;
    HashSet<Integer> visited;
    HashSet<Integer> currentPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        setMap = new HashMap();
        visited = new HashSet();
        currentPath = new HashSet();

        for (int i = 0; i < numCourses; i++) {
            setMap.put(i, new ArrayList());
        }

        for (int[] preq : prerequisites) {
            setMap.get(preq[0]).add(preq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visit(i))
                return false;
        }

        return true;

    }

    public boolean visit(int numCourse) {
        if (visited.contains(numCourse))
            return true;
        if (currentPath.contains(numCourse))
            return false;

        currentPath.add(numCourse);

        for (Integer value : setMap.get(numCourse)) {
            if (!visit(value))
                return false;
        }

        currentPath.remove(numCourse);
        visited.add(numCourse);

        return true;
    }

}