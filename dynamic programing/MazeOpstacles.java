class MazeOpstacles {
    public static int mazeObstecles(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        return fun(m - 1, n - 1, m, n, dp, grid);
    }

    // Using Memoization
    public static int fun(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = fun(i - 1, j, m, n, dp, grid) + fun(i, j - 1, m, n, dp, grid);
        return dp[i][j];
    }

    // Using Reccursion
    // public static int fun(int i, int j, int[][] grid, int m, int n, int ans) {
    // if (i == 0 && j == 0) {
    // return 1;
    // }

    // if (i < 0 || j < 0) {
    // return 0;
    // }
    // if (grid[i][j] == -1) {
    // return 0;
    // }
    // if (i >= 0 && j >= 0) {
    // ans = fun(i - 1, j, grid, m, n, ans) + fun(i, j - 1, grid, m, n, ans);
    // }
    // return ans;
    // }

    // Using MEMOIZATION

    public static void main(String[] args) {
        int[][] grid = { { 0, -1, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(mazeObstecles(grid, grid.length, grid[0].length));
    }
}