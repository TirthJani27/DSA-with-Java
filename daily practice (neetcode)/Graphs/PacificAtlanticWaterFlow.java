import java.util.*;

public class PacificAtlanticWaterFlow {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue pq = new ArrayDeque<>();
        Queue aq = new ArrayDeque<>();
        boolean[][] p_vis = new boolean[heights.length][heights[0].length];
        boolean[][] a_vis = new boolean[heights.length][heights[0].length];
        // Top edge
        for (int i = 0; i < heights[0].length; i++) {
            pq.add(new Pair(0, i));
            p_vis[0][i] = true;
        }

        // Left edge
        for (int i = 0; i < heights.length; i++) {
            pq.add(new Pair(i, 0));
            p_vis[i][0] = true;
        }
        for (int i = 0; i < a_vis[0].length; i++) {
            aq.add(new Pair(i, a_vis[0].length - 1));
            a_vis[a_vis[0].length - 1][i] = true;
        }
        for (int i = 1; i < a_vis.length; i++) {
            aq.add(new Pair(0, i));
            a_vis[0][i] = true;
        }

        bfs(pq, heights, p_vis);
        bfs(aq, heights, a_vis);

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (p_vis[i][j] && a_vis[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public static void bfs(Queue<Pair> q, int[][] heights, boolean[][] vis) {
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = heights.length;
        int n = heights[0].length;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for (int i = 0; i < direction.length; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && !vis[newX][newY]
                        && heights[x][y] <= heights[newX][newY]) {
                    q.add(new Pair(newX, newY));
                    vis[newX][newY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
