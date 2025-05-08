import java.util.ArrayDeque;
import java.util.Queue;

public class IslandAndTreasure {
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void islandsAndTreasure(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] help = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int x = curr.x;
                int y = curr.y;
                vis[x][y] = true;
                for (int j = 0; j < help.length; j++) {
                    int currY = y + help[j][1];
                    int currX = x + help[j][0];

                    if (0 <= currX && currX < grid.length && 0 <= currY && currY < grid[0].length && !vis[currX][currY]
                            && grid[currX][currY] != -1) {
                        grid[currX][currY] = Math.min(grid[currX][currY], dist+1);
                        q.add(new Pair(currX, currY));
                    }
                }
            }
            dist++;
        }

    }

    public static void printArray(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2147483647, -1, 0, 2147483647 },
                { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 },
                { 0, -1, 2147483647, 2147483647 }
        };
        printArray(grid);
        islandsAndTreasure(grid);
        printArray(grid);
    }
}
