class Solution {
    class InputPairs {
        int x;
        int y;

        InputPairs(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<InputPairs> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int steps = 0;
        int[][] ds = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        queue.add(new InputPairs(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        boolean startCase = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                startCase = false;
                InputPairs current = queue.poll();
                if (current.x == entrance[0] && current.y == entrance[1]) {
                    startCase = true;
                }
                if (!startCase) {
                    if (current.x == 0 || current.y == 0 || current.x == maze.length - 1 ||
                            current.y == maze[0].length - 1)
                        return steps;

                }

                for (int[] d : ds) {
                    int offsetX = current.x + d[0];
                    int offsetY = current.y + d[1];
                    if (offsetX < 0 || offsetX >= maze.length || offsetY < 0 || offsetY >= maze[0].length) {
                        continue;
                    }
                    if (visited[offsetX][offsetY])
                        continue;
                    if (maze[offsetX][offsetY] == '.') {
                        queue.add(new InputPairs(offsetX, offsetY));
                        visited[offsetX][offsetY] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
