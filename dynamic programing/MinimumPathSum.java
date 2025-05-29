public class MinimumPathSum {
    public static int minPathSum(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];
        return fun(grid, m - 1, n - 1, m, n, 0, dp);
    }
    // RECCURSIVE
    // public static int fun(int[][] grid, int i, int j, int m, int n, int sum) {
    // if (i == 0 && j == 0) {
    // return sum + grid[0][0];
    // }
    // if (i < 0 || j < 0) {
    // return Integer.MAX_VALUE;
    // }
    // return sum = grid[i][j] + Math.min(fun(grid, i - 1, j, m, n, sum), fun(grid,
    // i, j - 1, m, n, sum));
    // }

    // MEMOISATION
    public static int fun(int[][] grid, int i, int j, int m, int n, int sum, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int up = fun(grid, i - 1, j, m, n, sum, dp);
        int left = fun(grid, i, j - 1, m, n, sum, dp);
        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] grid = { { 5, 0, 0 }, { 11, 5, 2 } };
        System.out.println(minPathSum(grid, grid.length, grid[0].length));
    }
}
