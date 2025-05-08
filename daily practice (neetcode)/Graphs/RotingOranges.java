import java.util.ArrayDeque;
import java.util.Queue;

public class RotingOranges {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] help = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int fresh = 0;

        // Add all initially rotten oranges to queue and count fresh ones
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Pair currPair = q.poll();
                for (int k = 0; k < help.length; k++) {
                    int currX = currPair.x + help[k][0];
                    int currY = currPair.y + help[k][1];

                    if (0 <= currX && currX < grid.length && 0 <= currY && currY < grid[0].length
                            && !vis[currX][currY] && grid[currX][currY] == 1) {
                        flag = true;
                        grid[currX][currY] = 2;
                        vis[currX][currY] = true;
                        q.add(new Pair(currX, currY));
                        fresh--;
                    }
                }
            }

            if (flag)
                time++;
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        System.out.println(orangesRotting(grid));
    }
}
