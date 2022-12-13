class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int steps = 0;
        Pair[] directions = new Pair[] {
                new Pair(-1, 0), new Pair(0, -1), new Pair(0, 1), new Pair(1, 0)
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                for (Pair p : directions) {
                    int dx = curr.x + p.x;
                    int dy = curr.y + p.y;

                    if (dx >= 0 && dx <= grid.length - 1 && dy >= 0 && dy <= grid[0].length - 1
                            && grid[dx][dy] == 1) {
                        grid[dx][dy] = 2;
                        queue.add(new Pair(dx, dy));
                    }
                }
            }
            steps += 1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return steps == 0 ? steps : steps - 1;

    }
}
