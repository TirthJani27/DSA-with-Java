import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int[][] aux = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    vis[i][j] = true;
                    for (int k = 0; k < aux.length; k++) {
                        int currX = aux[k][0] + i;
                        int currY = aux[k][1] + j;
                        if (0 <= currX && currX < grid.length && 0 <= currY && currY < grid[0].length
                                && !vis[currX][currY]
                                && grid[currX][currY] == '1') {
                            q.add(new Pair(currX, currY));
                            vis[currX][currY] = true;
                        }
                    }
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        for (int k = 0; k < aux.length; k++) {
                            int currX = aux[k][0] + p.x;
                            int currY = aux[k][1] + p.y;
                            if (0 <= currX && currX < grid.length && 0 <= currY && currY < grid[0].length
                                    && !vis[currX][currY]
                                    && grid[currX][currY] == '1') {
                                q.add(new Pair(currX, currY));
                                vis[currX][currY] = true;
                            }
                        }

                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid));
    }
}
