import java.util.ArrayDeque;
import java.util.Queue;

public class MaxArea {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int currArea = 0;
        int[][] help = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    currArea++;
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                }
                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int x = curr.x;
                    int y = curr.y;
                    for (int k = 0; k < help.length; k++) {
                        int currX = help[k][0] + x;
                        int currY = help[k][1] + y;
                        if (0 <= currX && currX < vis.length && 0 <= currY && currY < vis[0].length
                                && !vis[currX][currY] && grid[currX][currY] == 1) {
                            q.add(new Pair(currX, currY));
                            vis[currX][currY] = true;
                            currArea++;
                        }
                    }

                }
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
                currArea = 0;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] array = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
        System.out.println(maxAreaOfIsland(array));
    }
}