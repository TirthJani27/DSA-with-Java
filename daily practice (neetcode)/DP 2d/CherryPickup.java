public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // return recursion(grid, 0, 0, n-1);

        // int dp[][][] = new int[m][n][n];
        // for(int arr[][] : dp){
        // for(int nums[] : arr){
        // Arrays.fill(nums, -1);
        // }
        // }
        // return memo(grid, 0, 0, n-1, dp);

        // return tabulation(grid, m, n);

        return spaceOpt(grid, m, n);
    }

    public int recursion(int grid[][], int i, int j1, int j2) {
        // write out of bound code.
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return Integer.MIN_VALUE / 100;
        }
        // Now You can write base case;
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j2];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // Now Our task is to traverse all possible paths.
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) { // for robot 1 bro.
            for (int dj2 = -1; dj2 <= 1; dj2++) { // for robot 2 bro
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1];
                } else {
                    value += grid[i][j1] + grid[i][j2];
                }
                value += recursion(grid, i + 1, j1 + dj1, j2 + dj2);
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public int memo(int grid[][], int i, int j1, int j2, int dp[][][]) {
        // write out of bound code.
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return Integer.MIN_VALUE / 100;
        }
        // Now You can write base case;
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j2];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) { // for robot 1 bro.
            for (int dj2 = -1; dj2 <= 1; dj2++) { // for robot 2 bro
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1];
                } else {
                    value += grid[i][j1] + grid[i][j2];
                }
                value += memo(grid, i + 1, j1 + dj1, j2 + dj2, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }

    // Tabulation
    public int tabulation(int grid[][], int m, int n) {
        // DP Initialization
        int dp[][][] = new int[m][n][n];

        // Base Case
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        // All Path Traversal.
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) { // for robot 1 bro.
                        for (int dj2 = -1; dj2 <= 1; dj2++) { // for robot 2 bro
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 + dj2 < n)
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][n - 1];
    }

    // Space Opt
    public int spaceOpt(int grid[][], int m, int n) {
        int front[][] = new int[n][n];

        // Base Case
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[m - 1][j1];
                } else {
                    front[j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        // All Path Traversal.
        for (int i = m - 2; i >= 0; i--) {
            int curr[][] = new int[n][n];
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE / 100;
                    for (int dj1 = -1; dj1 <= 1; dj1++) { // for robot 1 bro.
                        for (int dj2 = -1; dj2 <= 1; dj2++) { // for robot 2 bro
                            int value = 0;
                            if (j1 == j2)
                                value += grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];

                            if (j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 + dj2 < n)
                                value += front[j1 + dj1][j2 + dj2];
                            else
                                value += Integer.MIN_VALUE;
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            front = curr;
        }

        return front[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, -1 },
                { 1, 0, -1 },
                { 1, 1, 1 } };
        System.out.println(grid);
    }
}
