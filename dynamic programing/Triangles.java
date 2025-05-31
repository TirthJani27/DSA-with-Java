import java.util.*;

public class Triangles {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dfs(triangle, 0, 0, dp);
    }

    // Recursive DP with memoization, fixed logic and clearer parameter order
    private static int dfs(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        int n = triangle.size();
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int down = dfs(triangle, row + 1, col, dp);
        int diag = dfs(triangle, row + 1, col + 1, dp);
        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
        return dp[row][col];
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();

        listOfLists.add(Arrays.asList(2));
        listOfLists.add(Arrays.asList(3, 4));
        listOfLists.add(Arrays.asList(6, 5, 7));
        listOfLists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(listOfLists));

    }
}
